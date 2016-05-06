package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.deserializer.MessageFromDeserializer;
import ch.viascom.hipchat.api.models.message.MessageFrom;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.ViewPrivatechatHistory;
import ch.viascom.hipchat.api.response.ViewPrivatechatHistoryResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by Nikola Stankovic on 5/6/16.
 */
public class ViewPrivatechatHistoryRequest extends GetRequest<ViewPrivatechatHistoryResponse> {
    private ViewPrivatechatHistory viewPrivatechatHistory;

    public ViewPrivatechatHistoryRequest(ViewPrivatechatHistory viewPrivatechatHistory, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.viewPrivatechatHistory = viewPrivatechatHistory;
    }

    @Override
    protected String getPath() {
        return "/user/" + viewPrivatechatHistory.getIdOrEmail() + "/history";
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
        param.put("start-index", String.valueOf(viewPrivatechatHistory.getStartIndex()));
        param.put("max-results", String.valueOf(viewPrivatechatHistory.getMaxResults()));
        param.put("reverse", String.valueOf(viewPrivatechatHistory.isReverse()));
        param.put("include_deleted", String.valueOf(viewPrivatechatHistory.isIncludeDeleted()));
        param.put("date", String.valueOf(viewPrivatechatHistory.getDate()));
        param.put("timezone", String.valueOf(viewPrivatechatHistory.getTimezone()));
        param.put("end-date", String.valueOf(viewPrivatechatHistory.getEndDate()));
        return param;
    }
}
