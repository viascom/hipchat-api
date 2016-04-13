package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllMembers;
import ch.viascom.hipchat.api.response.GetAllMembersResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class GetAllMembersRequest extends GetRequest<GetAllMembersResponse> {
    private GetAllMembers getAllMembers;

    public GetAllMembersRequest(GetAllMembers getAllMembers, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllMembers = getAllMembers;
    }

    @Override
    protected String getPath() {
        return "/room/" + getAllMembers.getRoomId() + "/member";
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("start-index", String.valueOf(getAllMembers.getStart_index()));
        param.put("max-results", String.valueOf(getAllMembers.getMax_results()));
        return param;
    }
}
