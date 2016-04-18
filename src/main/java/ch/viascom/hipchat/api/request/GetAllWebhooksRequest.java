package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllWebhooks;
import ch.viascom.hipchat.api.response.GetAllWebhooksResponse;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 18.04.16.
 */
public class GetAllWebhooksRequest extends GetRequest<GetAllWebhooksResponse> {

    private GetAllWebhooks getAllWebhooks;

    public GetAllWebhooksRequest(GetAllWebhooks getAllWebhooks, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllWebhooks = getAllWebhooks;
    }

    @Override
    protected String getPath() {
        return "/room/" + getAllWebhooks.getRoomId() + "/webhook";
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("start-index", String.valueOf(getAllWebhooks.getStart_index()));
        param.put("max-results", String.valueOf(getAllWebhooks.getMax_results()));
        return param;
    }
}
