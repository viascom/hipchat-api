package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.FoxHttpResponse;
import ch.viascom.groundwork.foxhttp.annotation.types.*;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.models.Capabilities;
import ch.viascom.hipchat.api.models.Room;
import ch.viascom.hipchat.api.request.*;
import ch.viascom.hipchat.api.request.models.*;
import ch.viascom.hipchat.api.response.*;

@Path("{host}")
public interface RoomsAPI {

    @GET("/room/{room}")
    Room getRoom(@Path("room") String roomIdOrName);

    @POST("/room")
    FoxHttpResponse createRoom(@Body() Room room);

    @PUT("/room/{room}")
    FoxHttpResponse updateRoom(@Path("room") String roomIdOrName, @Body() Room room);

    @DELETE("/room/{room}")
    Room deleteRoom(@Path("room") String roomIdOrName);

    @GET("/room")
    Room getAllRoom(@Query("start-index") String startIndex,
                    @Query("max-results") String maxResults,
                    @Query("include-private") String includePrivate,
                    @Query("include-archived") String includeArchived);

    public NoContentResponse sendRoomNotification(SendNotification notification) throws APIException {
        SendNotificationRequest sendNotificationRequest = new SendNotificationRequest(notification, accessToken, baseUrl, httpClient, executorService);
        return sendNotificationRequest.execute();
    }

    /**
     * Send room message
     * <p>
     * Method: POST
     * Url:    /v2/room/{room_id_or_name}/message
     * Access: users
     *
     * @param message
     * @throws APIException
     */
    public NoContentResponse sendRoomMessage(SendMessage message) throws APIException {
        MessageRequest messageRequest = new MessageRequest(message, accessToken, baseUrl, httpClient, executorService);
        return messageRequest.execute();
    }

    /**
     * Reply to a message in a room.
     * <p>
     * Method: POST
     * Url:    /v2/room/{room_id_or_name}/reply
     * Access: users
     *
     * @param replyMessage
     * @throws APIException
     */
    public NoContentResponse replyToMessage(ReplyMessage replyMessage) throws APIException {
        ReplyMessageRequest replyMessageRequest = new ReplyMessageRequest(replyMessage, accessToken, baseUrl, httpClient, executorService);
        return replyMessageRequest.execute();
    }

    /**
     * Set a room's topic. Useful for displaying statistics, important links, server status, you name it!
     * <p>
     * Method: PUT
     * Url:    /v2/room/{room_id_or_name}/topic
     * Access: group clients, room clients, users
     *
     * @param topic
     * @throws APIException
     */
    public NoContentResponse setTopic(SetTopic topic) throws APIException {
        SetTopicRequest setTopicRequest = new SetTopicRequest(topic, accessToken, baseUrl, httpClient, executorService);
        return setTopicRequest.execute();
    }

    /**
     * Retrieve a webhook.
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}/extension/webhook/{key}
     * Access: group clients, room clients
     *
     * @param getRoomWebhook
     * @return
     * @throws APIException
     */
    public GetRoomWebhookResponse getRoomWebhook(GetRoomWebhook getRoomWebhook) throws APIException {
        GetRoomWebhookRequest getRoomWebhookRequest = new GetRoomWebhookRequest(getRoomWebhook, accessToken, baseUrl, httpClient, executorService);
        return getRoomWebhookRequest.execute();
    }

    /**
     * Create a webhook.
     * Dynamically created webhooks have the following restrictions:
     * - You can only create 10 webhooks in a room
     * - You cannot modify a webhook that was declared in the descriptor
     * <p>
     * Method: PUT
     * Url:    /v2/room/{room_id_or_name}/extension/webhook/{key}
     * Access: group clients, room clients
     *
     * @param createRoomWebhook
     * @return
     * @throws APIException
     */
    public CreateRoomWebhookResponse createRoomWebhook(CreateRoomWebhook createRoomWebhook) throws APIException {
        CreateRoomWebhookRequest createRoomWebhookRequest = new CreateRoomWebhookRequest(createRoomWebhook, accessToken, baseUrl, httpClient, executorService);
        return createRoomWebhookRequest.execute();
    }

    /**
     * Delete a webhook. You cannot delete a webhook that was declared in the descriptor.
     * <p>
     * Method: DELETE
     * Url:    /v2/room/{room_id_or_name}/extension/webhook/{key}
     * Access: group clients, room clients
     *
     * @param deleteRoomWebhook
     * @return
     * @throws APIException
     */
    public NoContentResponse deleteRoomWebhook(DeleteRoomWebhook deleteRoomWebhook) throws APIException {
        DeleteRoomWebhookRequest deleteRoomWebhookRequest = new DeleteRoomWebhookRequest(deleteRoomWebhook, accessToken, baseUrl, httpClient, executorService);
        return deleteRoomWebhookRequest.execute();
    }

    /**
     * Fetch one specific message by id
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}/history/{message_id}
     * Access: group clients, room clients, users
     *
     * @param getRoomMessage
     * @return
     * @throws APIException
     */
    public GetRoomMessageResponse getRoomMessage(GetRoomMessage getRoomMessage) throws APIException {
        GetRoomMessageRequest getRoomMessageRequest = new GetRoomMessageRequest(getRoomMessage, accessToken, baseUrl, httpClient, executorService);
        return getRoomMessageRequest.execute();
    }

    /**
     * Fetch chat history for this room.
     * NOTE:
     * - According to ISO-8601 the plus sign '+' is used for specifying the time offset from UTC. But '+' in a GET query is recognized as a whitespace by the API HTTP-server. For specifying the time offset, replace the character by '%2B' in the GET query.
     * - To fetch the history before '2015-06-16T15:33:30+01:00' you would use the query 'http://hipchat.com/v2/room/513/history?date=2015-06-16T15:33:30%2B01:00' (plus is replaced by '%2B').
     * - It's possible to specify the date using UNIX timestamp format: 'http://hipchat.com/v2/room/513/history?date=1434465210'.
     * - Same thing for the end-date parameter.
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}/history
     * Access: group clients, room clients, users
     *
     * @param viewRoomHistory
     * @return
     * @throws APIException
     */
    public ViewRoomHistoryResponse viewRoomHistory(ViewRoomHistory viewRoomHistory) throws APIException {
        ViewRoomHistoryRequest viewRoomHistoryRequest = new ViewRoomHistoryRequest(viewRoomHistory, accessToken, baseUrl, httpClient, executorService);
        return viewRoomHistoryRequest.execute();
    }

    /**
     * Fetch latest chat history for this room.
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}/history/latest
     * Access: group clients, room clients, users
     *
     * @param viewRecentRoomHistory
     * @return
     * @throws APIException
     */
    public ViewRecentRoomHistoryResponse viewRecentRoomHistory(ViewRecentRoomHistory viewRecentRoomHistory) throws APIException {
        ViewRecentRoomHistoryRequest viewRecentRoomHistoryRequest = new ViewRecentRoomHistoryRequest(viewRecentRoomHistory, accessToken, baseUrl, httpClient, executorService);
        return viewRecentRoomHistoryRequest.execute();
    }

    /**
     * Invite a user to a public room. This API can only be called using a user token which can be obtained through:
     * - Your own Personal API Token
     * - Generating a token using one of the following grant_types:
     *      - authorization_code -- This is the authorization step of a 3-legged OAuth 2 flow
     *      - refresh_token -- When a 3-legged OAuth token expires, you can request a new one through this grant_type
     *      - password -- This grant_type allows you to request a user token by providing a username/password
     * <p>
     * Method: POST
     * Url:    /v2/room/{room_id_or_name}/invite/{user_id_or_email}
     * Access: users
     *
     * @param inviteUser
     * @return
     * @throws APIException
     */
    public NoContentResponse inviteUser(InviteUser inviteUser) throws APIException {
        InviteUserRequest inviteUserRequest = new InviteUserRequest(inviteUser, accessToken, baseUrl, httpClient, executorService);
        return inviteUserRequest.execute();
    }

    /**
     * Gets all members for this private room.
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}/member
     * Access: group clients, room clients, users
     *
     * @param getAllMembers
     * @return
     * @throws APIException
     */
    public GetAllMembersResponse getAllMembers(GetAllMembers getAllMembers) throws APIException {
        GetAllMembersRequest getAllMembersRequest = new GetAllMembersRequest(getAllMembers, accessToken, baseUrl, httpClient, executorService);
        return getAllMembersRequest.execute();
    }

    /**
     * Adds a member to a private room and sends member's unavailable presence to all room members asynchronously.
     * <p>
     * Method: PUT
     * Url:    /v2/room/{room_id_or_name}/member/{user_id_or_email}
     * Access: group clients, room clients, users
     *
     * @param addMember
     * @return
     * @throws APIException
     */
    public NoContentResponse addMember(AddMember addMember) throws APIException {
        AddMemberRequest addMemberRequest = new AddMemberRequest(addMember, accessToken, baseUrl, httpClient, executorService);
        return addMemberRequest.execute();
    }

    /**
     * Removes a member from a private room.
     * <p>
     * Method: DELETE
     * Url:    /v2/room/{room_id_or_name}/member/{user_id_or_email}
     * Access: group clients, room clients, users.
     *
     * @param removeMember
     * @return
     * @throws APIException
     */
    public NoContentResponse removeMember(RemoveMember removeMember) throws APIException {
        RemoveMemberRequest removeMemberRequest = new RemoveMemberRequest(removeMember, accessToken, baseUrl, httpClient, executorService);
        return removeMemberRequest.execute();
    }

    /**
     * Gets all participants in this room.
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}/participant
     * Access: group clients, room clients, users
     *
     * @param getAllParticipants
     * @return
     * @throws APIException
     */
    public GetAllParticipantsResponse getAllParticipants(GetAllParticipants getAllParticipants) throws APIException {
        GetAllParticipantsRequest getAllParticipantsRequest = new GetAllParticipantsRequest(getAllParticipants, accessToken, baseUrl, httpClient, executorService);
        return getAllParticipantsRequest.execute();
    }

    /**
     * Fetch statistics for this room.
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}/statistics
     * Access: group clients, room clients, users
     *
     * @param roomId
     * @return
     * @throws APIException
     */
    public GetRoomStatisticsResponse getRoomStatistics(String roomId) throws APIException {
        GetRoomStatisticsRequest getRoomStatisticsRequest = new GetRoomStatisticsRequest(roomId, accessToken, baseUrl, httpClient, executorService);
        return getRoomStatisticsRequest.execute();
    }

    /**
     * Gets all webhooks for this room.
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}/webhook
     * Access: group clients, room clients, users
     *
     * @param getAllWebhooks
     * @return
     * @throws APIException
     */
    public GetAllWebhooksResponse getAllWebhooks(GetAllWebhooks getAllWebhooks) throws APIException {
        GetAllWebhooksRequest getAllWebhooksRequest = new GetAllWebhooksRequest(getAllWebhooks, accessToken, baseUrl, httpClient, executorService);
        return getAllWebhooksRequest.execute();
    }

    @Deprecated
    public void createWebhook() {
    }

    @Deprecated
    public void getWebhook() {
    }

    @Deprecated
    public void deleteWebhook() {
    }
}
