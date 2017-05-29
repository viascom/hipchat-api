package ch.viascom.hipchat.api;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.Capabilities;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CapabilitiesApiTest {

    @Test
    public void getCapabilitiesTest() throws FoxHttpException {
        HipChat hipChat = new HipChat("");
        Capabilities capabilities = hipChat.capabilitiesApi().getCapabilities();

        assertThat(capabilities.getVendor()).isNotNull();
    }
}
