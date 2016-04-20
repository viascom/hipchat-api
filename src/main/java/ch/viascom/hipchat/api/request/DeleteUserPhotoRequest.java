package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.DeleteRequest;
import ch.viascom.hipchat.api.response.NoContentResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 20.04.16.
 */
public class DeleteUserPhotoRequest extends DeleteRequest<NoContentResponse> {
    private String userId;

    public DeleteUserPhotoRequest(String userId, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.userId = userId;
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/user/" + userId + "/photo";
    }
}
