package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.response.NoContentResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 15.04.16.
 */
public class GetGroupAvatarRequest extends GetRequest<NoContentResponse> {
    private String groupId;

    public GetGroupAvatarRequest(String groupId, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.groupId = groupId;
    }

    @Override
    protected String getPath() {
        return "/group/" + groupId + "/avatar";
    }
}
