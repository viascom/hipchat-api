package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.models.Topic;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.request.generic.PutRequest;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class TopicRequest extends PutRequest<NoContentResponse> {
    private Topic topic;

    public TopicRequest(Topic topic, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.topic = topic;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(topic);
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/room/" + topic.getRoomId() + "/topic";
    }
}
