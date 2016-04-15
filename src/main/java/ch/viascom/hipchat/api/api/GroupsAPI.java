package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.UpdateGroupAvatarRequest;
import ch.viascom.hipchat.api.request.ViewGroupRequest;
import ch.viascom.hipchat.api.request.models.UpdateGroupAvatar;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.response.ViewGroupResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class GroupsAPI extends GenericAPI {

    public GroupsAPI(String baseUrl, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(baseUrl, accessToken, httpClient, executorService);
    }

    /**
     * Get a group's details.
     * <p>
     * Method: GET
     * Url:    /v2/group/{group_id}
     * Access: group clients, users
     *
     * @param groupId
     * @return
     * @throws APIException
     */
    public ViewGroupResponse viewGroup(String groupId) throws APIException {
        ViewGroupRequest viewGroupRequest = new ViewGroupRequest(groupId, baseUrl, accessToken, httpClient, executorService);
        return (ViewGroupResponse) viewGroupRequest.execute();
    }

    public void getGroupAvatar() {

    }

    /**
     * Update a group avatar. *API not ready*
     * <p>
     * Method: PUT
     * Url:    /v2/group/{group_id}/avatar
     * Access: group clients, users
     *
     * @param updateGroupAvatar
     * @return
     * @throws APIException
     */
    public NoContentResponse updateGroupAvatar(UpdateGroupAvatar updateGroupAvatar) throws APIException {
        UpdateGroupAvatarRequest updateGroupAvatarRequest = new UpdateGroupAvatarRequest(updateGroupAvatar, baseUrl, accessToken, httpClient, executorService);
        return (NoContentResponse) updateGroupAvatarRequest.execute();
    }

    public void deleteGroupAvatar() {

    }

    public void groupStatistics() {

    }
}
