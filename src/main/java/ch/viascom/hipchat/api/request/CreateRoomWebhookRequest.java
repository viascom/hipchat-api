package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.PutRequest;
import ch.viascom.hipchat.api.request.models.CreateRoomWebhook;
import ch.viascom.hipchat.api.response.CreateRoomWebhookResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 18.04.16.
 */
public class CreateRoomWebhookRequest extends PutRequest<CreateRoomWebhookResponse> {
    private CreateRoomWebhook createRoomWebhook;

    public CreateRoomWebhookRequest(CreateRoomWebhook createRoomWebhook, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.createRoomWebhook = createRoomWebhook;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(createRoomWebhook);
    }

    @Override
    protected String getPath() {
        return "/room/" + createRoomWebhook.getRoomId() + "/extension/webhook/" + createRoomWebhook.getKey();
    }
}
