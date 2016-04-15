package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.PutRequest;
import ch.viascom.hipchat.api.request.models.UpdateGroupAvatar;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 15.04.16.
 */
public class UpdateGroupAvatarRequest extends PutRequest<NoContentResponse> {
    private UpdateGroupAvatar updateGroupAvatar;

    public UpdateGroupAvatarRequest(UpdateGroupAvatar updateGroupAvatar, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.updateGroupAvatar = updateGroupAvatar;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(updateGroupAvatar, "groupId");
    }

    @Override
    protected String getPath() {
        return "/group/" + updateGroupAvatar.getGroupId() + "/avatar";
    }
}
