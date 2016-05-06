package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.models.*;
import ch.viascom.hipchat.api.request.models.*;
import ch.viascom.hipchat.api.response.*;
import ch.viascom.hipchat.api.request.*;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 11.04.16.
 */
public class RoomsAPI extends GenericAPI {

    public RoomsAPI(String baseUrl, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(baseUrl, accessToken, httpClient, executorService);
    }

    /**
     * Send room notification
     * <p>
     * Method: POST
     * Url:    /v2/room/{room_id_or_name}/notification
     * Access: group clients, room clients, users
     *
     * @param notification
     * @throws APIException
     */
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
     * List rooms for this group.
     * <p>
     * Method: GET
     * Url:    /v2/room
     * Access: group clients, users
     *
     * @param getAllRooms
     * @return
     * @throws APIException
     */
    public GetAllRoomsResponse getAllRooms(GetAllRooms getAllRooms) throws APIException {
        GetAllRoomsRequest getAllRoomsRequest = new GetAllRoomsRequest(getAllRooms, accessToken, baseUrl, httpClient, executorService);
        return getAllRoomsRequest.execute();
    }

    /**
     * Creates a new room.
     * <p>
     * Method: POST
     * Url:    /v2/room
     * Access: group clients, users
     *
     * @param room
     * @return
     * @throws APIException
     */
    public CreateRoomResponse createRoom(Room room) throws APIException {
        CreateRoomRequest createRoomRequest = new CreateRoomRequest(room, accessToken, baseUrl, httpClient, executorService);
        return createRoomRequest.execute();
    }

    /**
     * Get room details.
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}
     * Access: group clients, room clients, users
     *
     * @param roomId
     * @return
     * @throws APIException
     */
    public GetRoomResponse getRoom(String roomId) throws APIException {
        GetRoomRequet getRoomRequet = new GetRoomRequet(roomId, accessToken, baseUrl, httpClient, executorService);
        return getRoomRequet.execute();
    }

    /**
     * Updates a room.
     * <p>
     * Method: PUT
     * Url:    /v2/room/{room_id_or_name}
     * Access: group clients, users
     *
     * @param updateRoom
     * @throws APIException
     */
    public NoContentResponse updateRoom(UpdateRoom updateRoom) throws APIException {
        UpdateRoomRequest updateRoomRequest = new UpdateRoomRequest(updateRoom, accessToken, baseUrl, httpClient, executorService);
        return updateRoomRequest.execute();
    }

    /**
     * Deletes a room and kicks the current participants.
     * <p>
     * Method: DELETE
     * Url:    /v2/room/{room_id_or_name}
     * Access: group clients, users
     *
     * @param roomId
     * @throws APIException
     */
    public NoContentResponse deleteRoom(String roomId) throws APIException {
        DeleteRoomRequest deleteRoomRequest = new DeleteRoomRequest(roomId, accessToken, baseUrl, httpClient, executorService);
        return deleteRoomRequest.execute();
    }

    public void getRoomAvatar() {

    }

    /**
     * Update a room avatar.
     * <p>
     * Method: PUT
     * Url:    /v2/room/{room_id_or_name}/avatar
     * Access: group clients, room clients, users
     */
    public void updateRoomAvatar(UpdateRoomAvatar updateRoomAvatar) {

    }

    public void deleteRoomAvatar() {

    }

    public void getRoomAction() {

    }

    public void createRoomAction() {

    }

    public void deleteRoomAction() {

    }

    public void getRoomDialog() {

    }

    public void createRoomDialog() {

    }

    public void deleteRoomDialog() {

    }

    public void getRoomExternalPage() {

    }

    public void createRoomExternalPage() {

    }

    public void deleteRoomExternalPage() {

    }

    public void getRoomGlance() {

    }

    public void createRoomGlance() {

    }

    public void deleteRoomGlance() {

    }

    public void getRoomWebPanel() {

    }

    public void createRoomWebPanel() {

    }

    public void deleteRoomWebPanel() {

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

    public void removeMember() {

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

    public void shareFileWithRoom() {

    }

    public void shareLinkWithRoom() {

    }

    public void getRoomStatistics() {

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
