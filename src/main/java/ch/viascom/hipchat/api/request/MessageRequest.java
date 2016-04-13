package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.models.Message;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.request.generic.PostRequest;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class MessageRequest extends PostRequest<NoContentResponse> {
    private Message message;

    public MessageRequest(Message message, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.message = message;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(message);
    }

    @Override
    protected String getPath() {
        return "/room/" + message.getRoomId() + "/message";
    }
}
