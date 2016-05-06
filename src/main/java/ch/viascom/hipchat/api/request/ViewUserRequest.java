package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.response.ViewUserResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 19.04.16.
 */
public class ViewUserRequest extends GetRequest<ViewUserResponse> {
    private String userId;

    public ViewUserRequest(String userId, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.userId = userId;
    }

    @Override
    protected String getPath() {
        return "/user/" + userId;
    }
}
