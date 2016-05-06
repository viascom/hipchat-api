package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.models.Room;
import ch.viascom.hipchat.api.request.generic.PostRequest;
import ch.viascom.hipchat.api.response.CreateRoomResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class CreateRoomRequest extends PostRequest<CreateRoomResponse> {
    private Room room;

    public CreateRoomRequest(Room room, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.room = room;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(room);
    }

    @Override
    protected String getPath() {
        return "/room";
    }
}
