package ch.viascom.hipchat.api.api;

import ch.viascom.hipchat.api.api.generic.GenericAPI;
import ch.viascom.hipchat.api.exception.APIException;
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
     * @throws APIException
     */
    public GetEmoticonResponse getEmoticon(int emoticonId) throws APIException {
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
     * @throws APIException
     */
    public GetAllEmoticonsResponse getAllEmoticons(GetAllEmoticons getAllEmoticons) throws APIException {
        GetAllEmoticonsRequest getAllEmoticonsRequest = new GetAllEmoticonsRequest(getAllEmoticons, accessToken, baseUrl, httpClient, executorService);
        return getAllEmoticonsRequest.execute();

    }
}
