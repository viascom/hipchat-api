package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllUsers;
import ch.viascom.hipchat.api.response.GetAllUsersResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 18.04.16.
 */
public class GetAllUsersRequest extends GetRequest<GetAllUsersResponse> {
    private GetAllUsers getAllUsers;

    public GetAllUsersRequest(GetAllUsers getAllUsers, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllUsers = getAllUsers;
    }

    @Override
    protected String getPath() {
        return "/user";
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("start-index", String.valueOf(getAllUsers.getStart_index()));
        param.put("max-results", String.valueOf(getAllUsers.getMax_results()));
        param.put("include-guests", String.valueOf(getAllUsers.isInclude_guests()));
        param.put("include-deleted", String.valueOf(getAllUsers.isInclude_deleted()));
        return param;
    }
}
