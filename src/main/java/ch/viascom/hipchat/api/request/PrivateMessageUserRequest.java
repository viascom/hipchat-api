package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.models.PrivateMessage;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 19.04.16.
 */
public class PrivateMessageUserRequest extends PostRequest<NoContentResponse> {
    private PrivateMessage privateMessage;

    public PrivateMessageUserRequest(PrivateMessage privateMessage, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.privateMessage = privateMessage;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(privateMessage,"userId");
    }

    @Override
    protected String getPath() {
        return "/user/"+privateMessage.getUserId()+"/message";
    }
}
