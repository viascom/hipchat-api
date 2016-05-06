package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.response.ViewGroupResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class ViewGroupRequest extends GetRequest<ViewGroupResponse> {
    private String groupId;

    public ViewGroupRequest(String groupId, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.groupId = groupId;
    }

    @Override
    protected String getPath() {
        return "/group/" + groupId;
    }
}
