package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetAllWebhooks;
import ch.viascom.hipchat.api.response.GetAllWebhooksResponse;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 18.04.16.
 */
public class GetAllWebhooksRequest extends GetRequest<GetAllWebhooksResponse> {

    private GetAllWebhooks getAllWebhooks;

    public GetAllWebhooksRequest(GetAllWebhooks getAllWebhooks, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getAllWebhooks = getAllWebhooks;
        setQueryParams(new ArrayList<>(Arrays.asList("start_index", "max_results")), getAllWebhooks);
    }

    @Override
    protected String getPath() {
        return "/room/" + getAllWebhooks.getRoomId() + "/webhook";
    }

}
