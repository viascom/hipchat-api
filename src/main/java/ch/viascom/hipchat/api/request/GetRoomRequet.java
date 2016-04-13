package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.response.GetRoomResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 13.04.16.
 */
public class GetRoomRequet extends GetRequest<GetRoomResponse> {


    private String roomId;

    public GetRoomRequet(String roomId, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomId = roomId;
    }

    @Override
    protected String getPath() {
        return "/room/" + roomId;
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        return param;
    }
}
