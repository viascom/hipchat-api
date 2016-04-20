package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.models.PrivateMessage;
import ch.viascom.hipchat.api.request.*;
import ch.viascom.hipchat.api.request.models.*;
import ch.viascom.hipchat.api.response.*;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class UsersAPI extends GenericAPI {

    public UsersAPI(String baseUrl, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(baseUrl, accessToken, httpClient, executorService);
    }

    /**
     * List all users in the group.
     * <p>
     * Method: GET
     * Url:    /v2/user
     * Access: group clients, users
     *
     * @param getAllUsers
     * @return
     * @throws APIException
     */
    public GetAllUsersResponse getAllUsers(GetAllUsers getAllUsers) throws APIException {
        GetAllUsersRequest getAllUsersRequest = new GetAllUsersRequest(getAllUsers, accessToken, baseUrl, httpClient, executorService);
        return getAllUsersRequest.execute();
    }

    /**
     * Get a user's details.
     * <p>
     * Method: GET
     * Url:    /v2/user/{id_or_email}
     * Access: group clients, users
     *
     * @param userId
     * @return
     * @throws APIException
     */
    public ViewUserResponse viewUser(String userId) throws APIException {
        ViewUserRequest viewUserRequest = new ViewUserRequest(userId, accessToken, baseUrl, httpClient, executorService);
        return viewUserRequest.execute();
    }

    /**
     * Creates a new user.
     * If you don't specify a password you must record the one returned in the response as it can not be retrieved again.
     * To un-delete an existing user, you can call this resource.
     * <p>
     * Method: POST
     * Url:    /v2/user/
     * Access: group clients, users
     *
     * @param createUser
     * @return
     * @throws APIException
     */
    public CreateUserResponse createUser(CreateUser createUser) throws APIException {
        CreateUserRequest createUserRequest = new CreateUserRequest(createUser, accessToken, baseUrl, httpClient, executorService);
        return createUserRequest.execute();
    }

    /**
     * Delete a user.
     * <p>
     * Method: POST
     * Url:    /v2/user/{id_or_email}
     * Access: group clients, users
     *
     * @param userId
     * @return
     * @throws APIException
     */
    public NoContentResponse deleteUser(String userId) throws APIException {
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest(userId, accessToken, baseUrl, httpClient, executorService);
        return deleteUserRequest.execute();
    }

    /**
     * Update a user. A guest cannot be updated.
     * Changing a user's name or admin status will cause them to be briefly disconnected.
     * Only works on non-deleted users.
     * Any missing fields will be treated as deleted, so it is recommended to get the user, modify what you need, then call this resource to update.
     * <p>
     * <p>
     * Method: PUT
     * Url:    /v2/user/{id_or_email}
     * Access: group clients, users
     *
     * @param updateUser
     * @return
     * @throws APIException
     */
    public NoContentResponse updateUser(UpdateUser updateUser) throws APIException {
        UpdateUserRequest updateUserRequest = new UpdateUserRequest(updateUser, accessToken, baseUrl, httpClient, executorService);
        return updateUserRequest.execute();

    }

    /**
     * Sends a user a private message. This API can only be called using a user token which can be obtained through:
     * - Your own Personal API Token
     * - Generating a token using one of the following grant_types:
     * - authorization_code -- This is the authorization step of a 3-legged OAuth 2 flow
     * - refresh_token -- When a 3-legged OAuth token expires, you can request a new one through this grant_type
     * - password -- This grant_type allows you to request a user token by providing a username/password
     * The message can also be sent as text/plain
     * <p>
     * Method: POST
     * Url:    /v2/user/{id_or_email}/message
     * Access: users
     *
     * @param privateMessage
     * @return
     * @throws APIException
     */
    public NoContentResponse sendPrivateMessage(PrivateMessage privateMessage) throws APIException {
        PrivateMessageUserRequest privateMessageUserRequest = new PrivateMessageUserRequest(privateMessage, accessToken, baseUrl, httpClient, executorService);
        return privateMessageUserRequest.execute();

    }


    public String getPhoto(GetUserPhoto getUserPhoto) throws APIException {
        GetUserPhotoRequest getUserPhotoRequest = new GetUserPhotoRequest(getUserPhoto, accessToken, baseUrl, httpClient, executorService);
        return getUserPhotoRequest.execute().getResponseHeader().getResponseHeaders().get("Location");
    }

    /**
     * Update a user photo. A guest cannot be updated.
     * <p>
     * Method: PUT
     * Url:    /v2/user/{id_or_email}/photo
     * Access: group clients, users
     *
     * @param updateUserPhoto
     * @return
     * @throws APIException
     */
    public NoContentResponse updatePhoto(UpdateUserPhoto updateUserPhoto) throws APIException {
        UpdateUserPhotoRequest updateUserPhotoRequest = new UpdateUserPhotoRequest(updateUserPhoto, accessToken, baseUrl, httpClient, executorService);
        return updateUserPhotoRequest.execute();
    }

    /**
     * Delete a user photo. A guest cannot be updated.
     * <p>
     * Method: DELETE
     * Url:    /v2/user/{id_or_email}/photo
     * Access: group clients, users
     *
     * @param userId
     * @return
     * @throws APIException
     */
    public NoContentResponse deletePhoto(String userId) throws APIException {
        DeleteUserPhotoRequest deleteUserPhotoRequest = new DeleteUserPhotoRequest(userId, accessToken, baseUrl, httpClient, executorService);
        return deleteUserPhotoRequest.execute();
    }

    /**
     * Get the list of rooms a user joins when they log in.
     * <p>
     * Method: GET
     * Url:    /v2/user/{id_or_email}/preference/auto-join
     * Access: group clients, users
     *
     * @param getAutoJoinRooms
     * @return
     * @throws APIException
     */
    public GetAutoJoinRoomsResponse getAutoJoinRooms(GetAutoJoinRooms getAutoJoinRooms) throws APIException {
        GetAutoJoinRoomsRequest getAutoJoinRoomsRequest = new GetAutoJoinRoomsRequest(getAutoJoinRooms, accessToken, baseUrl, httpClient, executorService);
        return getAutoJoinRoomsRequest.execute();
    }
}
