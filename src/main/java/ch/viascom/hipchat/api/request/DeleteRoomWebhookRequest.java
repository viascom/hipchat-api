package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.DeleteRequest;
import ch.viascom.hipchat.api.request.models.DeleteRoomWebhook;
import ch.viascom.hipchat.api.response.NoContentResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 18.04.16.
 */
public class DeleteRoomWebhookRequest extends DeleteRequest<NoContentResponse> {
    private DeleteRoomWebhook deleteRoomWebhook;

    public DeleteRoomWebhookRequest(DeleteRoomWebhook deleteRoomWebhook, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.deleteRoomWebhook = deleteRoomWebhook;
    }

    @Override
    protected String getPath() {
        return "/room/" + deleteRoomWebhook.getRoomId() + "/extension/webhook/" + deleteRoomWebhook.getWebhookId();
    }
}
