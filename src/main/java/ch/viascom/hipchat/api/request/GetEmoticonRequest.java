package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.response.GetEmoticonResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class GetEmoticonRequest extends GetRequest<GetEmoticonResponse> {

    private int emoticonId;

    public GetEmoticonRequest(int emoticonId, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.emoticonId = emoticonId;
    }

    @Override
    protected String getPath() {
        return "/emoticon/" + emoticonId;
    }
}
