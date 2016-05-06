package ch.viascom.hipchat.api.request.generic;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.exception.AccessAPIException;
import ch.viascom.hipchat.api.exception.AuthorizationAPIException;
import ch.viascom.hipchat.api.response.GenericResponse;
import ch.viascom.hipchat.api.response.generic.ErrorResponse;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by patrickboesch on 11.04.16.
 */
public abstract class Request<T extends Response> {

    private static final Logger log = LogManager.getLogger(Request.class);

    protected ExecutorService executorService;
    protected String baseUrl;
    protected String accessToken;
    protected HttpClient httpClient;
    protected AuthorizationMethod authorizationMethod = AuthorizationMethod.HEADER;
    protected HashMap<String, String> queryParamMap = new HashMap<>();

    protected abstract HttpResponse request(AuthorizationMethod authorizationMethod) throws IOException, URISyntaxException;

    protected abstract String getJsonBody();

    protected void setQueryParams(ArrayList<String> params, Object o) throws APIException {
        try {
            Class<T> clazz = getParameterClass();

            HashMap<String, String> paramMap = new HashMap<>();

            for (String param : params) {
                Field field = clazz.getDeclaredField(param);

                String paramName = field.getName();

                SerializedName anno = field.getAnnotation(SerializedName.class);
                if (anno != null) {
                    paramName = anno.value();
                }

                String value = String.valueOf(field.get(o));

                if (field.get(o) != null && !value.isEmpty()) {
                    paramMap.put(paramName, value);
                }
            }

            queryParamMap = paramMap;
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorMessage(e.getMessage());
            throw new APIException(errorResponse, e.getMessage());
        }

    }

    protected abstract String getPath();

    protected Gson getGson() {
        Gson gson = new Gson();
        return gson;
    }

    protected String getEncodedPath() {
        String path = getPath();
        String[] tokens = path.split("/");
        String encodedPath = "";
        URLCodec urlCodec = new URLCodec();
        try {
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    //replace + to %20
                    encodedPath += "/" + urlCodec.encode(token).replace("+", "%20");
                }
            }
        } catch (EncoderException e) {
            log.error("Failed to encode the path properly.", e);
        }
        return encodedPath;
    }

    protected Request(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService, AuthorizationMethod authorizationMethod) {
        this.executorService = executorService;
        this.accessToken = accessToken;
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
        this.authorizationMethod = authorizationMethod;
    }

    public Future<Response> executeAsync() {
        Future<Response> future = executorService.submit(() -> execute());
        return future;
    }

    public T execute() throws APIException {
        Response output;
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            HttpResponse response = request(this.authorizationMethod);
            int status = response.getStatusLine().getStatusCode();
            responseHeader.setResponseHeaders(response.getAllHeaders());
            responseHeader.setStatusCode(status);
            responseHeader.setRequestPath(baseUrl + getEncodedPath());
            HttpEntity entity = response.getEntity();
            String content = entity != null ? EntityUtils.toString(entity) : null;
            if (status >= 200 && status < 300) {
                log.debug("-> Response status: " + status);

                if (content != null) {
                    if (getParameterClass() == GenericResponse.class) {
                        output = new GenericResponse(entity);
                    } else {
                        Gson gson = getGson();
                        output = gson.fromJson(content, getParameterClass());
                    }
                } else {
                    //NoContentResponse
                    output = getParameterClass().newInstance();
                }
                output.setResponseHeader(responseHeader);
                return (T) output;
            } else {
                log.error("-> Invalid response status: " + status);
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setRequestBody(getJsonBody());
                errorResponse.setResponseBody(content);
                errorResponse.setResponseHeader(responseHeader);
                switch (status) {
                    case 401:
                        throw new AuthorizationAPIException(errorResponse, "Response-Statuscode: " + String.valueOf(status));
                    case 403:
                        throw new AccessAPIException(errorResponse, "Response-Statuscode: " + String.valueOf(status));
                    default:
                        throw new APIException(errorResponse, "Response-Statuscode: " + String.valueOf(status));
                }

            }
        } catch (Exception e) {
            if (e instanceof APIException) {
                //Pass through APIExceptions
                throw (APIException) e;
            } else {
                log.error("API-Error - " + e.getMessage());
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setErrorMessage(e.getMessage());
                errorResponse.setResponseHeader(responseHeader);
                throw new APIException(errorResponse, e.getMessage());
            }
        }
    }

    protected Class<T> getParameterClass() {
        return (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
