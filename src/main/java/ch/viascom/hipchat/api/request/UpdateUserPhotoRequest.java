package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.models.UpdateUserPhoto;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 20.04.16.
 */
public class UpdateUserPhotoRequest extends PutRequest<NoContentResponse> {
    private UpdateUserPhoto updateUserPhoto;

    public UpdateUserPhotoRequest(UpdateUserPhoto updateUserPhoto, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.updateUserPhoto = updateUserPhoto;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(updateUserPhoto, "userId");
    }

    @Override
    protected String getPath() {
        return "/user/" + updateUserPhoto.getUserId() + "/photo";
    }
}
