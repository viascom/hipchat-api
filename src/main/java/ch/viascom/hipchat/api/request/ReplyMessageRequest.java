package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.models.ReplyMessage;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.request.generic.PostRequest;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class ReplyMessageRequest extends PostRequest<NoContentResponse> {
    private ReplyMessage replyMessage;

    public ReplyMessageRequest(ReplyMessage replyMessage, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.replyMessage = replyMessage;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(replyMessage);
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/room/" + replyMessage.getRoomId() + "/reply";
    }
}
