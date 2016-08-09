package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.response.GetRoomStatisticsResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * @author patrick.boesch@viascom.ch
 */
public class GetRoomStatisticsRequest extends GetRequest<GetRoomStatisticsResponse> {
    private String roomId;

    public GetRoomStatisticsRequest(String roomId, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomId = roomId;
    }

    @Override
    protected String getPath() {
        return "/room/" + roomId + "/statistics";
    }
}
