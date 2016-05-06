package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllUsers;
import ch.viascom.hipchat.api.response.GetAllUsersResponse;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 18.04.16.
 */
public class GetAllUsersRequest extends GetRequest<GetAllUsersResponse> {
    private GetAllUsers getAllUsers;

    public GetAllUsersRequest(GetAllUsers getAllUsers, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllUsers = getAllUsers;
        setQueryParams(new ArrayList<>(Arrays.asList("start_index", "max_results", "include_guests", "include_deleted")), getAllUsers);
    }

    @Override
    protected String getPath() {
        return "/user";
    }

}
