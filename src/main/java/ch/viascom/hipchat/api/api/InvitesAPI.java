package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.InviteUserToGroupRequest;
import ch.viascom.hipchat.api.request.models.InviteUserToGroup;
import ch.viascom.hipchat.api.response.InviteUserToGroupResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by nikolastankovic on 20.08.2016.
 */
public class InvitesAPI extends GenericAPI{

    public InvitesAPI(String baseUrl, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(baseUrl, accessToken, httpClient, executorService);
    }

    /**
     * Invites a user to join a group.
     * <p>
     * Method: POST
     * Url:    /v2/invite/user
     * Access: group clients, users
     *
     * @param inviteUserToGroup
     * @return
     * @throws APIException
     */
    public InviteUserToGroupResponse inviteUserToGroup(InviteUserToGroup inviteUserToGroup) throws APIException {
        InviteUserToGroupRequest inviteUserToGroupRequest = new InviteUserToGroupRequest(inviteUserToGroup, accessToken, baseUrl, httpClient, executorService);
        return inviteUserToGroupRequest.execute();
    }
}

