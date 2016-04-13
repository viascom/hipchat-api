package ch.viascom.hipchat.api.request.generic;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 11.04.16.
 */
public abstract class DeleteRequest<T> extends Request<T> {

    private static final Logger log = LogManager.getLogger(PostRequest.class);

    protected DeleteRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
    }

    protected String getJsonBody() {
        return null;
    }

    @Override
    protected HttpResponse request() throws IOException {
        String encodedPath = getEncodedPath();
        log.debug("DELETE - path: {}", encodedPath);

        HttpDelete httpDelete = new HttpDelete(baseUrl + encodedPath);
        httpDelete.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        httpDelete.addHeader(new BasicHeader("Content-Type", "application/json"));
        return httpClient.execute(httpDelete, HttpClientContext.create());
    }
}
