package ch.viascom.hipchat.api;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.response.GetCapabilitiesResponse;
import org.junit.Test;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
public class CapabilitiesAPITest {

    @Test
    public void getCapabilitiesTest() throws APIException {
        HipChat hipChat = new HipChat();
        GetCapabilitiesResponse response = hipChat.capabilitiesAPI().getCapabilities();
    }
}
