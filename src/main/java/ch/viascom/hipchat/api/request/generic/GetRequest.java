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
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 11.04.16.
 */
public abstract class GetRequest<T extends Response> extends Request<T> {
    private static final Logger log = LogManager.getLogger(PostRequest.class);

    protected GetRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService, AuthorizationMethod authorizationMethod) {
        super(accessToken, baseUrl, httpClient, executorService, authorizationMethod);
    }

    protected GetRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService, AuthorizationMethod.HEADER);
    }

    protected String getJsonBody() {
        return null;
    }

    @Override
    protected HttpResponse request(AuthorizationMethod authorizationMethod) throws IOException, URISyntaxException {
        String encodedPath = getEncodedPath();
        log.debug("GET - path: {}", encodedPath);

        HttpGet httpGet = new HttpGet(baseUrl + encodedPath);

        // Prepare Query
        URIBuilder builder = new URIBuilder(httpGet.getURI());
        HashMap<String, String> param = queryParamMap;
        if(param != null && !param.isEmpty()) {
            for (String key : param.keySet()) {
                builder.setParameter(key, param.get(key).toString());
            }
        }
        if (authorizationMethod == AuthorizationMethod.QUERY) {
            builder.setParameter("auth_token", accessToken);
        }
        httpGet.setURI(builder.build());

        // Prepare Header
        if (authorizationMethod == AuthorizationMethod.HEADER) {
            httpGet.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        }
        httpGet.addHeader(new BasicHeader("Content-Type", "application/json"));


        return httpClient.execute(httpGet, HttpClientContext.create());
    }
}
