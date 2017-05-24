package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.AuthorizationMethod;
import ch.viascom.hipchat.api.request.models.GetUserPhoto;
import ch.viascom.hipchat.api.response.GenericResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 19.04.16.
 */
public class GetUserPhotoRequest extends GetRequest<GenericResponse> {
    private GetUserPhoto getUserPhoto;

    public GetUserPhotoRequest(GetUserPhoto getUserPhoto, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService, AuthorizationMethod.QUERY);
        this.getUserPhoto = getUserPhoto;
    }

    @Override
    protected String getPath() {
        return "/user/" + getUserPhoto.getUserId() + "/photo/" + getUserPhoto.getSize().toString().toLowerCase();
    }
}
