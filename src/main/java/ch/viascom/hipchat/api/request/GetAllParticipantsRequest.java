package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllParticipants;
import ch.viascom.hipchat.api.response.GetAllParticipantsResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class GetAllParticipantsRequest extends GetRequest<GetAllParticipantsResponse> {
    private GetAllParticipants getAllParticipants;

    public GetAllParticipantsRequest(GetAllParticipants getAllParticipants, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllParticipants = getAllParticipants;
    }

    @Override
    protected String getPath() {
        return "/room/" + getAllParticipants.getRoomId() + "/participant";
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("start-index", String.valueOf(getAllParticipants.getStart_index()));
        param.put("max-results", String.valueOf(getAllParticipants.getMax_results()));
        param.put("include-offline", String.valueOf(getAllParticipants.isInclude_offline()));
        return param;
    }
}
