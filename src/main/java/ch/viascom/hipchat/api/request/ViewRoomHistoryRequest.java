package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.deserializer.MessageFromDeserializer;
import ch.viascom.hipchat.api.models.message.MessageFrom;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.ViewRoomHistory;
import ch.viascom.hipchat.api.response.ViewRoomHistoryResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
public class ViewRoomHistoryRequest extends GetRequest<ViewRoomHistoryResponse> {
    private ViewRoomHistory viewRoomHostory;

    public ViewRoomHistoryRequest(ViewRoomHistory viewRoomHostory, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.viewRoomHostory = viewRoomHostory;
    }

    @Override
    protected String getPath() {
        return "/room/" + viewRoomHostory.getRoomId() + "/history";
    }

    @Override
    protected Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        // Use Custom TypeAdapter (MessageFromDeserializer) because "from" can be an object or a string
        gsonBuilder.registerTypeAdapter(MessageFrom.class, new MessageFromDeserializer());
        Gson gson = gsonBuilder.create();

        return gson;
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("start-index", String.valueOf(viewRoomHostory.getStart_index()));
        param.put("max-results", String.valueOf(viewRoomHostory.getMax_results()));
        param.put("reverse", String.valueOf(viewRoomHostory.isReverse()));
        param.put("include_deleted", String.valueOf(viewRoomHostory.isInclude_deleted()));
        param.put("date", String.valueOf(viewRoomHostory.getDate()));
        param.put("timezone", String.valueOf(viewRoomHostory.getTimezone()));
        param.put("end-date", String.valueOf(viewRoomHostory.getEnd_date()));
        return param;
    }
}
