package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.models.GetAllRooms;
import ch.viascom.hipchat.api.response.GetAllRoomsResponse;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class GetAllRoomsRequest extends GetRequest<GetAllRoomsResponse> {

    private GetAllRooms getAllRooms;

    public GetAllRoomsRequest(GetAllRooms getAllRooms, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllRooms = getAllRooms;
    }

    @Override
    protected String getPath() {
        return "/room";
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("start-index", String.valueOf(getAllRooms.getStart_index()));
        param.put("max-results", String.valueOf(getAllRooms.getMax_results()));
        param.put("include-private", String.valueOf(getAllRooms.isInclude_private()));
        param.put("include-archived", String.valueOf(getAllRooms.isInclude_archived()));
        return param;
    }
}
