package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.generic.AuthorizationMethod;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.response.GetCapabilitiesResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
public class GetCapabilitiesRequest extends GetRequest<GetCapabilitiesResponse> {
    public GetCapabilitiesRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService, AuthorizationMethod.NONE);
    }

    @Override
    protected String getPath() {
        return "/capabilities";
    }
}
