package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.models.*;
import ch.viascom.hipchat.api.request.models.GetAllMembers;
import ch.viascom.hipchat.api.request.models.GetAllRooms;
import ch.viascom.hipchat.api.request.models.UpdateRoom;
import ch.viascom.hipchat.api.request.models.UpdateRoomAvatar;
import ch.viascom.hipchat.api.response.CreateRoomResponse;
import ch.viascom.hipchat.api.response.GetAllMembersResponse;
import ch.viascom.hipchat.api.response.GetAllRoomsResponse;
import ch.viascom.hipchat.api.request.*;
import ch.viascom.hipchat.api.response.GetRoomResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 11.04.16.
 */
public class RoomsAPI extends GenericAPI{

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
     */
    public void sendRoomNotification(Notification notification) {
        NotificationRequest notificationRequest = new NotificationRequest(notification, accessToken, baseUrl, httpClient, executorService);
        notificationRequest.execute();
    }

    /**
     * Send room message
     * <p>
     * Method: POST
     * Url:    /v2/room/{room_id_or_name}/message
     * Access: users
     *
     * @param message
     */
    public void sendRoomMessage(Message message) {
        MessageRequest messageRequest = new MessageRequest(message, accessToken, baseUrl, httpClient, executorService);
        messageRequest.execute();
    }

    /**
     * Reply to a message in a room.
     * <p>
     * Method: POST
     * Url:    /v2/room/{room_id_or_name}/reply
     * Access: users
     *
     * @param replyMessage
     */
    public void replyToMessage(ReplyMessage replyMessage) {
        ReplyMessageRequest replyMessageRequest = new ReplyMessageRequest(replyMessage, accessToken, baseUrl, httpClient, executorService);
        replyMessageRequest.execute();
    }

    /**
     * Set a room's topic. Useful for displaying statistics, important links, server status, you name it!
     * <p>
     * Method: PUT
     * Url:    /v2/room/{room_id_or_name}/topic
     * Access: group clients, room clients, users
     *
     * @param topic
     */
    public void setTopic(Topic topic) {
        TopicRequest topicRequest = new TopicRequest(topic, accessToken, baseUrl, httpClient, executorService);
        topicRequest.execute();
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
     */
    public GetAllRoomsResponse getAllRooms(GetAllRooms getAllRooms) {
        GetAllRoomsRequest getAllRoomsRequest = new GetAllRoomsRequest(getAllRooms, accessToken, baseUrl, httpClient, executorService);
        return (GetAllRoomsResponse) getAllRoomsRequest.execute();
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
     */
    public CreateRoomResponse createRoom(Room room) {
        CreateRoomRequest createRoomRequest = new CreateRoomRequest(room, accessToken, baseUrl, httpClient, executorService);
        return (CreateRoomResponse) createRoomRequest.execute();
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
     */
    public GetRoomResponse getRoom(String roomId) {
        GetRoomRequet getRoomRequet = new GetRoomRequet(roomId, accessToken, baseUrl, httpClient, executorService);
        return (GetRoomResponse) getRoomRequet.execute();
    }

    /**
     * Updates a room.
     * <p>
     * Method: PUT
     * Url:    /v2/room/{room_id_or_name}
     * Access: group clients, users
     *
     * @param updateRoom
     */
    public void updateRoom(UpdateRoom updateRoom) {
        UpdateRoomRequest updateRoomRequest = new UpdateRoomRequest(updateRoom, accessToken, baseUrl, httpClient, executorService);
        updateRoomRequest.execute();
    }

    /**
     * Deletes a room and kicks the current participants.
     * <p>
     * Method: DELETE
     * Url:    /v2/room/{room_id_or_name}
     * Access: group clients, users
     *
     * @param roomId
     */
    public void deleteRoom(String roomId) {
        DeleteRoomRequest deleteRoomRequest = new DeleteRoomRequest(roomId, accessToken, baseUrl, httpClient, executorService);
        deleteRoomRequest.execute();
    }

    public void getRoomAvatar() {

    }

    /**
     * Update a room avatar.
     * <p>
     * Method: PUT
     * Url:    /v2/room/{room_id_or_name}/avatar
     * Access: group clients, room clients, users
     *
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

    public void getRoomWebhook() {

    }

    public void createRoomWebhook() {

    }

    public void deleteRoomWebhook() {

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
     *
     * <p>
     * Method: GET
     * Url:    /v2/room/{room_id_or_name}/member
     * Access: group clients, room clients, users
     *
     * @param getAllMembers
     * @return
     */
    public GetAllMembersResponse getAllMembers(GetAllMembers getAllMembers) {
        GetAllMembersRequest getAllMembersRequest = new GetAllMembersRequest(getAllMembers, accessToken, baseUrl, httpClient, executorService);
        return (GetAllMembersResponse) getAllMembersRequest.execute();
    }

    public void addMember() {

    }

    public void removeMember() {

    }

    public void getAllParticipants() {

    }

    public void shareFileWithRoom() {

    }

    public void shareLinkWithRoom() {

    }

    public void getRoomStatistics() {

    }

    public void getAllWebhooks() {

    }

    public void createWebhook() {

    }

    public void getWebhook() {

    }

    public void deleteWebhook() {

    }
}
