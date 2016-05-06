package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllParticipants;
import ch.viascom.hipchat.api.response.GetAllParticipantsResponse;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class GetAllParticipantsRequest extends GetRequest<GetAllParticipantsResponse> {
    private GetAllParticipants getAllParticipants;

    public GetAllParticipantsRequest(GetAllParticipants getAllParticipants, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllParticipants = getAllParticipants;
        setQueryParams(new ArrayList<>(Arrays.asList("start_index", "max_results","include-offline")), getAllParticipants);
    }

    @Override
    protected String getPath() {
        return "/room/" + getAllParticipants.getRoomId() + "/participant";
    }

}
