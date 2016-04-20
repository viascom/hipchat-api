package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.GetAutoJoinRoomsRequest;
import ch.viascom.hipchat.api.request.models.GetAutoJoinRooms;
import ch.viascom.hipchat.api.response.GetAutoJoinRoomsResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 20.04.16.
 */
public class PrefsPublicsAPI extends GenericAPI {
    public PrefsPublicsAPI(String baseUrl, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(baseUrl, accessToken, httpClient, executorService);
    }

    /**
     * Get the list of rooms a user joins when they log in.
     * <p>
     * Method: GET
     * Url:    /v2/user/{id_or_email}/preference/auto-join
     * Access: group clients, users
     *
     * @param getAutoJoinRooms
     * @return
     * @throws APIException
     */
    public GetAutoJoinRoomsResponse getAutoJoinRooms(GetAutoJoinRooms getAutoJoinRooms) throws APIException {
        GetAutoJoinRoomsRequest getAutoJoinRoomsRequest = new GetAutoJoinRoomsRequest(getAutoJoinRooms, accessToken, baseUrl, httpClient, executorService);
        return getAutoJoinRoomsRequest.execute();
    }
}
