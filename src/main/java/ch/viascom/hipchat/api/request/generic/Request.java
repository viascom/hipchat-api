package ch.viascom.hipchat.api.request.generic;

import ch.viascom.hipchat.api.response.generic.ErrorResponse;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import com.google.gson.Gson;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
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

    protected abstract HttpResponse request() throws IOException;

    protected abstract String getJsonBody();

    protected abstract String getPath();

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

    protected Request(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        this.executorService = executorService;
        this.accessToken = accessToken;
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
    }

    public Future<Response> executeAsync() {
        Future<Response> future = executorService.submit(() -> execute());
        return future;
    }

    public Response execute() {
        Response output;
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            HttpResponse response = request();
            int status = response.getStatusLine().getStatusCode();
            responseHeader.setResponseHeaders(response.getAllHeaders());
            responseHeader.setStatusCode(status);
            responseHeader.setRequestPath(getEncodedPath());
            HttpEntity entity = response.getEntity();
            String content = entity != null ? EntityUtils.toString(entity) : null;
            if (status >= 200 && status < 300) {
                log.debug("-> Response status: " + status);

                if (content != null) {
                    Gson gson = new Gson();
                    output = gson.fromJson(content, getParameterClass());
                } else {
                    //NoContentResponse
                    output = getParameterClass().newInstance();
                }
                output.setResponseHeader(responseHeader);
                return output;
            } else {
                log.error("-> Invalid response status: " + status);
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setRequestBody(getJsonBody());
                errorResponse.setResponseBody(content);
                output = errorResponse;
                output.setResponseHeader(responseHeader);
                return output;
            }
        } catch (Exception e) {
            log.error("API-Error - " + e.getMessage());
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorMessage(e.getMessage());
            output = errorResponse;
            output.setResponseHeader(responseHeader);
            return output;
        }
    }

    protected Class<T> getParameterClass() {
        return (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
