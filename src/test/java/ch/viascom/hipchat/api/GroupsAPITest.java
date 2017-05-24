package ch.viascom.hipchat.api;

import ch.viascom.hipchat.api.request.models.UpdateGroupAvatar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by patrickboesch on 15.04.16.
 */
public class GroupsAPITest {
    private static final Logger log = LogManager.getLogger(EmoticonsAPITest.class);
    private static final String clientToken = "";
    private static final String integrationToken = "";

    //@Test
    public void viewGroupTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsAPI().viewGroup("");
    }

    //@Test
    public void getGroupAvatarTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsAPI().getGroupAvatar("");
    }

    //@Test
    public void updateGroupAvatarTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsAPI().updateGroupAvatar(new UpdateGroupAvatar("",""));
    }

    //@Test
    public void deleteGroupAvatarTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsAPI().deleteGroupAvatar("");
    }

    //@Test
    public void groupStatisticsTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsAPI().groupStatistics("");
    }
}
