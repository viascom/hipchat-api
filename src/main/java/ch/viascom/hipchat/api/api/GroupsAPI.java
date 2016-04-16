package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.*;
import ch.viascom.hipchat.api.request.models.UpdateGroupAvatar;
import ch.viascom.hipchat.api.response.GroupStatisticsResponse;
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
        return viewGroupRequest.execute();
    }

    /**
     * Gets a group avatar. *API not ready - Return Statuscode: 302*
     * <p>
     * Method: GET
     * Url:    /v2/group/{group_id}/avatar
     * Access: group clients, users
     *
     * @param groupId
     * @return
     * @throws APIException
     */
    public NoContentResponse getGroupAvatar(String groupId) throws APIException{
        GetGroupAvatarRequest getGroupAvatarRequest = new GetGroupAvatarRequest(groupId, baseUrl, accessToken, httpClient, executorService);
        return getGroupAvatarRequest.execute();
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
        return updateGroupAvatarRequest.execute();
    }

    /**
     * Delete group avatar.
     * <p>
     * Method: DELETE
     * Url:    /v2/group/{group_id}/avatar
     * Access: group clients, users
     *
     * @param groupId
     * @return
     * @throws APIException
     */
    public NoContentResponse deleteGroupAvatar(String groupId) throws APIException {
        DeleteGroupAvatarRequest deleteGroupAvatarRequest = new DeleteGroupAvatarRequest(groupId, baseUrl, accessToken, httpClient, executorService);
        return deleteGroupAvatarRequest.execute();
    }

    /**
     * Get a group's details.
     * <p>
     * Method: GET
     * Url:    /v2/group/{group_id}/statistics
     * Access: group clients, users
     *
     * @param groupId
     * @return
     * @throws APIException
     */
    public GroupStatisticsResponse groupStatistics(String groupId) throws APIException {
        GroupStatisticsRequest groupStatisticsRequest = new GroupStatisticsRequest(groupId, baseUrl, accessToken, httpClient, executorService);
        return groupStatisticsRequest.execute();
    }
}
