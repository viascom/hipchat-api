package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAutoJoinRooms;
import ch.viascom.hipchat.api.response.GetAutoJoinRoomsResponse;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 20.04.16.
 */
public class GetAutoJoinRoomsRequest extends GetRequest<GetAutoJoinRoomsResponse> {
    private GetAutoJoinRooms getAutoJoinRooms;

    public GetAutoJoinRoomsRequest(GetAutoJoinRooms getAutoJoinRooms, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAutoJoinRooms = getAutoJoinRooms;
        setQueryParams(new ArrayList<>(Arrays.asList("start_index", "max_results")), getAutoJoinRooms);
    }

    @Override
    protected String getPath() {
        return "/user/" + getAutoJoinRooms.getUserId() + "/preference/auto-join";
    }

}
