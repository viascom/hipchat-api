package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.PostRequest;
import ch.viascom.hipchat.api.request.models.InviteUserToGroup;
import ch.viascom.hipchat.api.response.InviteUserToGroupResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by nikolastankovic on 20.08.2016.
 */
public class InviteUserToGroupRequest extends PostRequest<InviteUserToGroupResponse> {
    private InviteUserToGroup inviteUserToGroup;

    public InviteUserToGroupRequest(InviteUserToGroup inviteUserToGroup, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.inviteUserToGroup = inviteUserToGroup;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(inviteUserToGroup);
    }

    @Override
    protected String getPath() {
        return "/invite/user";
    }
}
