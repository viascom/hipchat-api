package ch.viascom.hipchat.api;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.models.InviteUserToGroup;
import ch.viascom.hipchat.api.response.InviteUserToGroupResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by nikol on 20.08.2016.
 */
public class InvitesAPITest {

    private static final Logger log = LogManager.getLogger(InvitesAPITest.class);
    private static final String clientToken = "";
    private static String testBotUserEmail = "";

    //@Test
    public void inviteUserToGroupTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        InviteUserToGroupResponse inviteUserToGroupResponse = hipChat.invitesAPI().inviteUserToGroup(new InviteUserToGroup("",testBotUserEmail,"HipChat-Bot"));
    }
}
