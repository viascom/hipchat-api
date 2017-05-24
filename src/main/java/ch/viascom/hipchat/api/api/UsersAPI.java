package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.FoxHttpResponse;
import ch.viascom.groundwork.foxhttp.annotation.types.*;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.models.PrivateMessage;
import ch.viascom.hipchat.api.models.User;
import ch.viascom.hipchat.api.request.*;
import ch.viascom.hipchat.api.request.models.*;
import ch.viascom.hipchat.api.response.*;

@Path("{host}")
public interface UsersAPI {

    @GET("/user")
    GetAllUsersResponse getAllUsers() throws FoxHttpException;

    @POST("/user")
    FoxHttpResponse createUser(@Body CreateUser createUser) throws FoxHttpException;

    @GET("/user/{id}")
    User viewUser(@Path("id") String idOrEmail) throws FoxHttpException;

    @PUT("/user/{id}")
    @SkipResponseBody(true)
    FoxHttpResponse updateUser(@Path("id") String idOrEmail,
                               @Body UpdateUser updateUser) throws FoxHttpException;

    @DELETE("/user/{id}")
    @SkipResponseBody(true)
    FoxHttpResponse deleteUser(@Path("id") String idOrEmail) throws FoxHttpException;

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


    public GenericResponse getPhoto(GetUserPhoto getUserPhoto) throws APIException {
        GetUserPhotoRequest getUserPhotoRequest = new GetUserPhotoRequest(getUserPhoto, accessToken, baseUrl, httpClient, executorService);
        return getUserPhotoRequest.execute();
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

    /**
     * Fetch one specific message by id
     * <p>
     * Method: GET
     * Url:    /v2/user/{id_or_email}/history/{message_id}
     * Access: group clients, users
     *
     * @param getPrivatechatMessage
     * @return
     * @throws APIException
     */
    public GetPrivatechatMessageResponse GetPrivatechatMessage(GetPrivatechatMessage getPrivatechatMessage) throws APIException {
        GetPrivatechatMessageRequest getPrivatechatMessageRequest = new GetPrivatechatMessageRequest(getPrivatechatMessage, accessToken, baseUrl, httpClient, executorService);
        return getPrivatechatMessageRequest.execute();
    }

    /**
     * Fetch chat history for the 1:1 chat with the user identified by idoremail.
     * NOTE:
     * - According to ISO-8601 the plus sign '+' is used for specifying the time offset from UTC. But '+' in a GET query is recognized as a whitespace by the API HTTP-server. For specifying the time offset, replace the character by '%2B' in the GET query.
     * - To fetch the history before '2015-06-16T15:33:30+01:00' you would use the query 'http://hipchat.com/v2/user/513/history?date=2015-06-16T15:33:30%2B01:00' (plus is replaced by '%2B').
     * - It's possible to specify the date using UNIX timestamp format: 'http://hipchat.com/v2/user/513/history?date=1434465210'.
     * - Same thing for the end-date parameter.
     * <p>
     * Method: GET
     * Url:    /v2/user/{id_or_email}/history
     * Access: users
     *
     * @param viewPrivatechatHistory
     * @return
     * @throws APIException
     */
    public ViewPrivatechatHistoryResponse viewPrivatechatHistory(ViewPrivatechatHistory viewPrivatechatHistory) throws APIException {
        ViewPrivatechatHistoryRequest viewPrivatechatHistoryRequest = new ViewPrivatechatHistoryRequest(viewPrivatechatHistory, accessToken, baseUrl, httpClient, executorService);
        return viewPrivatechatHistoryRequest.execute();
    }

    /**
     * Fetch latest chat history for the 1:1 chat with the user identified by idoremail.
     * <p>
     * Method: GET
     * Url:    /v2/user/{id_or_email}/history/latest
     * Access: users
     *
     * @param viewRecentPrivatechatHistory
     * @return
     * @throws APIException
     */
    public ViewRecentPrivatechatHistoryResponse viewRecentPrivatechatHistory(ViewRecentPrivatechatHistory viewRecentPrivatechatHistory) throws APIException {
        ViewRecentPrivatechatHistoryRequest viewRecentPrivatechatHistoryRequest = new ViewRecentPrivatechatHistoryRequest(viewRecentPrivatechatHistory, accessToken, baseUrl, httpClient, executorService);
        return viewRecentPrivatechatHistoryRequest.execute();
    }
}
