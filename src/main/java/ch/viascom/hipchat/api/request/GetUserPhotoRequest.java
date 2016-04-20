package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetUserPhoto;
import ch.viascom.hipchat.api.response.NoContentResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 19.04.16.
 */
public class GetUserPhotoRequest extends GetRequest<NoContentResponse> {
    private GetUserPhoto getUserPhoto;

    public GetUserPhotoRequest(GetUserPhoto getUserPhoto, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getUserPhoto = getUserPhoto;
    }

    @Override
    protected String getPath() {
        return "/user/" + getUserPhoto.getUserId() + "/photo/" + getUserPhoto.getSize().toString().toLowerCase();
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        return param;
    }
}
