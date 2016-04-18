package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.GetAllUsersRequest;
import ch.viascom.hipchat.api.request.models.GetAllUsers;
import ch.viascom.hipchat.api.response.GetAllUsersResponse;
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
}
