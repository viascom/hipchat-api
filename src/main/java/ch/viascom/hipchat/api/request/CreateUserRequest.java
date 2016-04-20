package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.PostRequest;
import ch.viascom.hipchat.api.request.models.CreateUser;
import ch.viascom.hipchat.api.response.CreateUserResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 19.04.16.
 */
public class CreateUserRequest extends PostRequest<CreateUserResponse> {
    private CreateUser createUser;

    public CreateUserRequest(CreateUser createUser, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.createUser = createUser;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(createUser);
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/user";
    }
}
