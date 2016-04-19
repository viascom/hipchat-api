package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.*;
import ch.viascom.hipchat.api.request.models.CreateUser;
import ch.viascom.hipchat.api.request.models.GetAllUsers;
import ch.viascom.hipchat.api.request.models.UpdateUser;
import ch.viascom.hipchat.api.response.CreateUserResponse;
import ch.viascom.hipchat.api.response.GetAllUsersResponse;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.response.ViewUserResponse;
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
        GetAllUsersRequest getAllUsersRequest = new GetAllUsersRequest(getAllUsers, baseUrl, accessToken, httpClient, executorService);
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
        ViewUserRequest viewUserRequest = new ViewUserRequest(userId, baseUrl, accessToken, httpClient, executorService);
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
        CreateUserRequest createUserRequest = new CreateUserRequest(createUser, baseUrl, accessToken, httpClient, executorService);
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
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest(userId, baseUrl, accessToken, httpClient, executorService);
        return deleteUserRequest.execute();
    }

    /**
     * Update a user. A guest cannot be updated.
     * Changing a user's name or admin status will cause them to be briefly disconnected.
     * Only works on non-deleted users.
     * Any missing fields will be treated as deleted, so it is recommended to get the user, modify what you need, then call this resource to update.
     *
     * <p>
     * Method: PUT
     * Url:    /v2/user/{id_or_email}
     * Access: group clients, users
     *
     * @param updateUser
     * @return
     * @throws APIException
     */
    public NoContentResponse updateUser(UpdateUser updateUser) throws APIException{
        UpdateUserRequest updateUserRequest = new UpdateUserRequest(updateUser, baseUrl, accessToken, httpClient, executorService);
        return updateUserRequest.execute();

    }
}
