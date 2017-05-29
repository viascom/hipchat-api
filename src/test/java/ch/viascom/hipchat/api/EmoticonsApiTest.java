package ch.viascom.hipchat.api;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.emoticon.EmoticonType;
import org.junit.Test;

public class EmoticonsApiTest {

    private static final String apiAccessToken = ""; // Place here your API Access token

    @Test
    public void getEmoticonTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(apiAccessToken);
        hipChat.emoticonsApi().getEmoticon("19106");
    }

    @Test
    public void getAllEmoticons() throws FoxHttpException {
        HipChat hipChat = new HipChat(apiAccessToken);
        hipChat.emoticonsApi().getAllEmoticons("0", "100", EmoticonType.ALL.toString());
    }
}
