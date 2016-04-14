package ch.viascom.hipchat.api.request.generic;

import ch.viascom.hipchat.api.response.generic.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
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
public abstract class GetRequest<T extends Response> extends Request<T> {
    private static final Logger log = LogManager.getLogger(PostRequest.class);

    protected GetRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
    }

    protected String getJsonBody() {
        return null;
    }

    protected abstract HashMap<String, String> getQueryParam();

    @Override
    protected HttpResponse request() throws IOException {
        String encodedPath = getEncodedPath();
        log.debug("GET - path: {}", encodedPath);

        HttpGet httpGet = new HttpGet(baseUrl + encodedPath);
        httpGet.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        httpGet.addHeader(new BasicHeader("Content-Type", "application/json"));

        try {

            URIBuilder builder = new URIBuilder(httpGet.getURI());

            HashMap<String, String> param = getQueryParam();

            for (String key : param.keySet()) {
                builder.setParameter(key, param.get(key).toString());
            }

            URI uri = builder.build();
            httpGet.setURI(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return httpClient.execute(httpGet, HttpClientContext.create());
    }
}
