package ch.viascom.hipchat.api.request.generic;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 11.04.16.
 */
public abstract class PostRequest<T> extends Request<T> {

    private static final Logger log = LogManager.getLogger(PostRequest.class);

    protected PostRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
    }

    @Override
    protected HttpResponse request() throws IOException {
        String jsonBody = getJsonBody();
        String encodedPath = getEncodedPath();
        log.debug("POST - path: {}", encodedPath);

        HttpPost httpPost = new HttpPost(baseUrl + encodedPath);
        httpPost.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        httpPost.addHeader(new BasicHeader("Content-Type", "application/json"));
        httpPost.setEntity(new StringEntity(jsonBody, Consts.UTF_8));
        return httpClient.execute(httpPost, HttpClientContext.create());
    }
}
