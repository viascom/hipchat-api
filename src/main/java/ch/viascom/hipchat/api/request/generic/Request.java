package ch.viascom.hipchat.api.request.generic;

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
public abstract class Request<T> {

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

    public Future<T> executeAsync() {
        Future<T> future = executorService.submit(() -> execute());
        return future;
    }

    public T execute() {
        try {
            HttpResponse response = request();
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String content = entity != null ? EntityUtils.toString(entity) : null;
            if (status >= 200 && status < 300) {
                log.debug("-> Response status: " + status);
                if (content == null) {
                    //should be NoContentResponse
                    return getParameterClass().newInstance();
                }
                Gson gson = new Gson();
                return gson.fromJson(content, getParameterClass());
            } else {
                log.error("Invalid response status: {}, content: {}", status, content);
                return null;
            }
        } catch (Exception e) {
            log.error("API-Error - " + e.getMessage());
        }
        return null;
    }

    protected Class<T> getParameterClass() {
        return (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
