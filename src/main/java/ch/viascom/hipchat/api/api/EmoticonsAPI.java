package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.models.Emoticon;
import ch.viascom.hipchat.api.request.GetAllEmoticonsRequest;
import ch.viascom.hipchat.api.request.GetEmoticonRequest;
import ch.viascom.hipchat.api.request.models.GetAllEmoticons;
import ch.viascom.hipchat.api.response.GetAllEmoticonsResponse;
import ch.viascom.hipchat.api.response.GetEmoticonResponse;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class EmoticonsAPI extends GenericAPI {

    public EmoticonsAPI(String baseUrl, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(baseUrl, accessToken, httpClient, executorService);
    }

    /**
     * Get emoticon details.
     * <p>
     * Method: GET
     * Url:    /v2/emoticon/{emoticon_id_or_shortcut}
     * Access: group clients, room clients, users
     *
     * @param emoticonId
     * @return
     */
    public GetEmoticonResponse getEmoticon(int emoticonId) {
        GetEmoticonRequest getEmoticonRequest = new GetEmoticonRequest(emoticonId, accessToken, baseUrl, httpClient, executorService);
        return getEmoticonRequest.execute();
    }

    /**
     * Gets all emoticons for the current group.
     * <p>
     * Method: GET
     * Url:    /v2/emoticon
     * Access: group clients, room clients, users
     *
     * @param getAllEmoticons
     * @return
     */
    public GetAllEmoticonsResponse getAllEmoticons(GetAllEmoticons getAllEmoticons) {
        GetAllEmoticonsRequest getAllEmoticonsRequest = new GetAllEmoticonsRequest(getAllEmoticons, accessToken, baseUrl, httpClient, executorService);
        return getAllEmoticonsRequest.execute();

    }
}
