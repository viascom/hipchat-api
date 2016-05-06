package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.deserializer.MessageFromDeserializer;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.models.message.MessageFrom;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.ViewRoomHistory;
import ch.viascom.hipchat.api.response.ViewRoomHistoryResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
public class ViewRoomHistoryRequest extends GetRequest<ViewRoomHistoryResponse> {
    private ViewRoomHistory viewRoomHistory;

    public ViewRoomHistoryRequest(ViewRoomHistory viewRoomHistory, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.viewRoomHistory = viewRoomHistory;
        setQueryParams(new ArrayList<>(Arrays.asList("start_index", "max_results","isReverse","isInclude_deleted", "date", "timezone", "end_date")), viewRoomHistory);
    }

    @Override
    protected String getPath() {
        return "/room/" + viewRoomHistory.getRoomId() + "/history";
    }

    @Override
    protected Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        // Use Custom TypeAdapter (MessageFromDeserializer) because "from" can be an object or a string
        gsonBuilder.registerTypeAdapter(MessageFrom.class, new MessageFromDeserializer());
        Gson gson = gsonBuilder.create();

        return gson;
    }
}
