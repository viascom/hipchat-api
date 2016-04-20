package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAutoJoinRooms;
import ch.viascom.hipchat.api.response.GetAutoJoinRoomsResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 20.04.16.
 */
public class GetAutoJoinRoomsRequest extends GetRequest<GetAutoJoinRoomsResponse> {
    private GetAutoJoinRooms getAutoJoinRooms;

    public GetAutoJoinRoomsRequest(GetAutoJoinRooms getAutoJoinRooms, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAutoJoinRooms = getAutoJoinRooms;
    }

    @Override
    protected String getPath() {
        return "/user/" + getAutoJoinRooms.getUserId() + "/preference/auto-join";
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("start-index", String.valueOf(getAutoJoinRooms.getStart_index()));
        param.put("max-results", String.valueOf(getAutoJoinRooms.getMax_results()));
        return param;
    }
}
