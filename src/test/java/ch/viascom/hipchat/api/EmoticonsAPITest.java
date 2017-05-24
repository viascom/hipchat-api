package ch.viascom.hipchat.api;

import ch.viascom.hipchat.api.request.models.GetAllEmoticons;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class EmoticonsAPITest {

    private static final Logger log = LogManager.getLogger(EmoticonsAPITest.class);
    private static final String clientToken = "";
    private static final String integrationToken = "";

    //@Test
    public void getEmoticonTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.emoticonsAPI().getEmoticon(19106);
    }

    //@Test
    public void getAllEmoticons() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.emoticonsAPI().getAllEmoticons(new GetAllEmoticons());
    }
}
