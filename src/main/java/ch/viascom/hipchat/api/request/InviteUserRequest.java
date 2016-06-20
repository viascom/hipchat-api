package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.PostRequest;
import ch.viascom.hipchat.api.request.models.InviteUser;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by Patrick Bösch on 06.05.16.
 */
public class InviteUserRequest extends PostRequest<NoContentResponse> {
    private InviteUser inviteUser;

    public InviteUserRequest(InviteUser inviteUser, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.inviteUser = inviteUser;
    }

    @Override
    protected String getJsonBody() {
        String json = JsonUtil.getJsonBody(inviteUser, "room_id_or_name");
        // replace second query field
        json = json.replaceAll("\"user_id_or_email\"\"\\:[^\\,\\}]*,", "");
        return json;
    }

    @Override
    protected String getPath() {
        return "/room/" + inviteUser.getRoom_id_or_name() + "/invite/" + inviteUser.getUser_id_or_email();
    }
}
