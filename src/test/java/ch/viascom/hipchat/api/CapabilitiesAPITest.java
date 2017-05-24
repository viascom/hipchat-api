package ch.viascom.hipchat.api;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import org.junit.Test;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
public class CapabilitiesAPITest {

    @Test
    public void getCapabilitiesTest() throws FoxHttpException {
        HipChat hipChat = new HipChat("ea9e287429c170ab9478707e912029");
        GetCapabilitiesResponse response = hipChat.capabilitiesAPI().getCapabilities();
    }
}
