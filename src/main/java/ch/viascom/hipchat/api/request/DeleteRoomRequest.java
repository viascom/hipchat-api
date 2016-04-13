package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.request.generic.DeleteRequest;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class DeleteRoomRequest extends DeleteRequest<NoContentResponse> {
    private String roomId;

    public DeleteRoomRequest(String roomId, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomId = roomId;
    }

    @Override
    protected String getPath() {
        return "/room/" + roomId;
    }
}
