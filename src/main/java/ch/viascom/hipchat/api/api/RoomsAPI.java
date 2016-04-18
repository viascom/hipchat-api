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
    public NoContentResponse sendRoomNotification(Notification notification) throws APIException {
        NotificationRequest notificationRequest = new NotificationRequest(notification, accessToken, baseUrl, httpClient, executorService);
        return notificationRequest.execute();
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
    public NoContentResponse sendRoomMessage(Message message) throws APIException {
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
    public NoContentResponse setTopic(Topic topic) throws APIException {
        TopicRequest topicRequest = new TopicRequest(topic, accessToken, baseUrl, httpClient, executorService);
        return topicRequest.execute();
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
     *  - You can only create 10 webhooks in a room
     *  - You cannot modify a webhook that was declared in the descriptor
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
        CreateRoomWebhookRequest createRoomWebhookRequest = new CreateRoomWebhookRequest(createRoomWebhook,accessToken, baseUrl, httpClient, executorService);
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

    public void getRoomMessage() {

    }

    public void viewRoomHistory() {

    }

    public void viewRecentRoomHistory() {

    }

    public void inviteUser() {

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

    public void addMember() {

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
