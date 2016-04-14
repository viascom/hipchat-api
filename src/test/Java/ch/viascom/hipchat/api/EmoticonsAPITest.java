package ch.viascom.hipchat.api;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.request.models.GetAllEmoticons;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class EmoticonsAPITest {

    private static final Logger log = LogManager.getLogger(EmoticonsAPITest.class);
    private static final String clientToken = "";
    private static final String integrationToken = "";

    @Test
    public void getEmoticonTest(){
        HipChat hipChat = new HipChat(clientToken);
        try {
            hipChat.emoticonsAPI().getEmoticon(19106);
        } catch (APIException e) {
            e.printStackTrace();
            log.debug(e.getErrorResponse());
        }
    }

    //@Test
    public void getAllEmoticons(){
        HipChat hipChat = new HipChat(clientToken);
        try {
            hipChat.emoticonsAPI().getAllEmoticons(new GetAllEmoticons());
        } catch (APIException e) {
            e.printStackTrace();
        }
    }
}
