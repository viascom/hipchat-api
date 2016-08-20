package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.GetCapabilitiesRequest;
import ch.viascom.hipchat.api.response.GetCapabilitiesResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
public class CapabilitiesAPI extends GenericAPI {
    public CapabilitiesAPI(String baseUrl, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(baseUrl, accessToken, httpClient, executorService);
    }

    /**
     * Gets the capabilities descriptor for HipChat
     * Authentication not required.
     * <p>
     * Method: GET
     * Url:    /v2/capabilities
     *
     * @return
     * @throws APIException
     */
    public GetCapabilitiesResponse getCapabilities() throws APIException {
        GetCapabilitiesRequest getCapabilitiesRequest = new GetCapabilitiesRequest(accessToken, baseUrl, httpClient, executorService);
        return getCapabilitiesRequest.execute();
    }


}
