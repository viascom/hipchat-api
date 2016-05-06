package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllMembers;
import ch.viascom.hipchat.api.response.GetAllMembersResponse;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class GetAllMembersRequest extends GetRequest<GetAllMembersResponse> {
    private GetAllMembers getAllMembers;

    public GetAllMembersRequest(GetAllMembers getAllMembers, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllMembers = getAllMembers;
        setQueryParams(new ArrayList<>(Arrays.asList("start_index", "max_results")), getAllMembers);
    }

    @Override
    protected String getPath() {
        return "/room/" + getAllMembers.getRoomId() + "/member";
    }

}
