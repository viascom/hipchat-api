package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.response.GroupStatisticsResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 15.04.16.
 */
public class GroupStatisticsRequest extends GetRequest<GroupStatisticsResponse> {
    private String groupId;

    public GroupStatisticsRequest(String groupId, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.groupId = groupId;
    }

    @Override
    protected String getPath() {
        return "/group/" + groupId + "/statistics";
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        return param;
    }
}
