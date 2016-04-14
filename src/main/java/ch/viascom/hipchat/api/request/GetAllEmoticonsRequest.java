package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllEmoticons;
import ch.viascom.hipchat.api.response.GetAllEmoticonsResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class GetAllEmoticonsRequest extends GetRequest<GetAllEmoticonsResponse> {
    private GetAllEmoticons getAllEmoticons;

    public GetAllEmoticonsRequest(GetAllEmoticons getAllEmoticons, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllEmoticons = getAllEmoticons;
    }

    @Override
    protected String getPath() {
        return "/emoticon";
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("start-index", String.valueOf(getAllEmoticons.getStart_index()));
        param.put("max-results", String.valueOf(getAllEmoticons.getMax_results()));
        param.put("type", String.valueOf(getAllEmoticons.getType()));
        return param;
    }

}
