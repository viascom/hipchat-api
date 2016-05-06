package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllEmoticons;
import ch.viascom.hipchat.api.response.GetAllEmoticonsResponse;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class GetAllEmoticonsRequest extends GetRequest<GetAllEmoticonsResponse> {
    private GetAllEmoticons getAllEmoticons;

    public GetAllEmoticonsRequest(GetAllEmoticons getAllEmoticons, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllEmoticons = getAllEmoticons;
        setQueryParams(new ArrayList<>(Arrays.asList("start_index", "max_results", "type")), getAllEmoticons);
    }

    @Override
    protected String getPath() {
        return "/emoticon";
    }

}
