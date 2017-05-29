package ch.viascom.hipchat.api;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.Capabilities;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
public class CapabilitiesApiTest {

    @Test
    public void getCapabilitiesTest() throws FoxHttpException {
        HipChat hipChat = new HipChat("");
        Capabilities capabilities = hipChat.capabilitiesApi().getCapabilities();

        assertThat(capabilities.getVendor()).isNotNull();
    }
}
