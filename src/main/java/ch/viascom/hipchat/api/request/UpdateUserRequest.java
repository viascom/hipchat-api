package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.PutRequest;
import ch.viascom.hipchat.api.request.models.UpdateUser;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 19.04.16.
 */
public class UpdateUserRequest extends PutRequest<NoContentResponse> {
    private UpdateUser updateUser;

    public UpdateUserRequest(UpdateUser updateUser, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.updateUser = updateUser;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(updateUser,"userId");
    }

    @Override
    protected String getPath() {
        return "/user/" + updateUser.getUserId();
    }
}
