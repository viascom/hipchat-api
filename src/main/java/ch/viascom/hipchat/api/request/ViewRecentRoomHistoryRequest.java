package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.deserializer.MessageFromDeserializer;
import ch.viascom.hipchat.api.deserializer.MessageLinkDeserializer;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.models.message.MessageFrom;
import ch.viascom.hipchat.api.models.message.MessageLink;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.ViewRecentRoomHistory;
import ch.viascom.hipchat.api.response.ViewRecentRoomHistoryResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
public class ViewRecentRoomHistoryRequest extends GetRequest<ViewRecentRoomHistoryResponse> {
    private ViewRecentRoomHistory viewRecentRoomHistory;

    public ViewRecentRoomHistoryRequest(ViewRecentRoomHistory viewRecentRoomHistory, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.viewRecentRoomHistory = viewRecentRoomHistory;
        setQueryParams(new ArrayList<>(Arrays.asList("max_results","isInclude_deleted", "timezone", "not_before")), viewRecentRoomHistory);
    }

    @Override
    protected String getPath() {
        return "/room/" + viewRecentRoomHistory.getRoomId() + "/history/latest";
    }

    @Override
    protected Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        // Use Custom TypeAdapter (MessageFromDeserializer) because "from" can be an object or a string
        gsonBuilder.registerTypeAdapter(MessageFrom.class, new MessageFromDeserializer());
        gsonBuilder.registerTypeAdapter(MessageLink.class, new MessageLinkDeserializer());
        Gson gson = gsonBuilder.create();

        return gson;
    }
}
