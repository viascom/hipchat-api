package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.models.Room;
import ch.viascom.hipchat.api.request.generic.PutRequest;
import ch.viascom.hipchat.api.request.models.UpdateRoom;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class UpdateRoomRequest extends PutRequest<NoContentResponse> {
    private UpdateRoom updateRoom;

    public UpdateRoomRequest(UpdateRoom updateRoom, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.updateRoom = updateRoom;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(updateRoom);
    }

    @Override
    protected String getPath() {
        return "/room/" + updateRoom.getName();
    }
}
