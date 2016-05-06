package ch.viascom.hipchat.api.request.generic;

import ch.viascom.hipchat.api.response.generic.Response;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
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
public abstract class PostRequest<T extends Response> extends Request<T> {

    private static final Logger log = LogManager.getLogger(PostRequest.class);

    protected PostRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService, AuthorizationMethod authorizationMethod) {
        super(accessToken, baseUrl, httpClient, executorService, authorizationMethod);
    }

    protected PostRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService, AuthorizationMethod.HEADER);
    }

    @Override
    protected HttpResponse request(AuthorizationMethod authorizationMethod) throws IOException, URISyntaxException {
        String jsonBody = getJsonBody();
        String encodedPath = getEncodedPath();
        log.debug("POST - path: {}", encodedPath);

        HttpPost httpPost = new HttpPost(baseUrl + encodedPath);
        // Prepare Query
        URIBuilder builder = new URIBuilder(httpPost.getURI());
        HashMap<String, String> param = queryParamMap;
        if(param != null && !param.isEmpty()) {
            for (String key : param.keySet()) {
                builder.setParameter(key, param.get(key).toString());
            }
        }
        if (authorizationMethod == AuthorizationMethod.QUERY) {
            builder.setParameter("auth_token", accessToken);
        }
        httpPost.setURI(builder.build());

        // Prepare Header
        if (authorizationMethod == AuthorizationMethod.HEADER) {
            httpPost.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        }
        httpPost.addHeader(new BasicHeader("Content-Type", "application/json"));
        httpPost.setEntity(new StringEntity(jsonBody, Consts.UTF_8));
        return httpClient.execute(httpPost, HttpClientContext.create());
    }
}
