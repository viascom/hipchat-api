package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllRooms;
import ch.viascom.hipchat.api.response.GetAllRoomsResponse;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class GetAllRoomsRequest extends GetRequest<GetAllRoomsResponse> {

    private GetAllRooms getAllRooms;

    public GetAllRoomsRequest(GetAllRooms getAllRooms, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllRooms = getAllRooms;
        setQueryParams(new ArrayList<>(Arrays.asList("start_index", "max_results", "include_private", "include_archived")), getAllRooms);
    }

    @Override
    protected String getPath() {
        return "/room";
    }

}
