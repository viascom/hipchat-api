package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetRoomWebhook;
import ch.viascom.hipchat.api.response.GetRoomWebhookResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 18.04.16.
 */
public class GetRoomWebhookRequest extends GetRequest<GetRoomWebhookResponse> {
    private GetRoomWebhook getRoomWebhook;

    public GetRoomWebhookRequest(GetRoomWebhook getRoomWebhook, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getRoomWebhook = getRoomWebhook;
    }

    @Override
    protected String getPath() {
        return "/room/" + getRoomWebhook.getRoomId() + "/extension/webhook/" + getRoomWebhook.getWebhookId();
    }

}
