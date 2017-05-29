package ch.viascom.hipchat.api;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.User;
import org.junit.Ignore;
import org.junit.Test;

public class InvitesApiTest {

    private static final String clientToken = "";
    private static String testBotUserEmail = "info@viascom.ch";

    @Test
    @Ignore // HipChat doesn't work here
    public void inviteUserToGroupTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        User user = hipChat.invitesApi().inviteUserToGroup("", testBotUserEmail, "HipChat-Bot");
    }
}
