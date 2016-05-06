package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.deserializer.MessageFromDeserializer;
import ch.viascom.hipchat.api.models.message.MessageFrom;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.ViewRecentPrivatechatHistory;
import ch.viascom.hipchat.api.response.ViewRecentPrivatechatHistoryResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by Nikola Stankovic on 5/6/16.
 */
public class ViewRecentPrivatechatHistoryRequest extends GetRequest<ViewRecentPrivatechatHistoryResponse> {
    private ViewRecentPrivatechatHistory viewRecentPrivatechatHistory;

    public ViewRecentPrivatechatHistoryRequest(ViewRecentPrivatechatHistory viewRecentPrivatechatHistory, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.viewRecentPrivatechatHistory = viewRecentPrivatechatHistory;
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        HashMap<String, String> param = new HashMap<>();
        param.put("max-results", String.valueOf(viewRecentPrivatechatHistory.getMaxResults()));
        param.put("include_deleted", String.valueOf(viewRecentPrivatechatHistory.isIncludeDeleted()));
        param.put("timezone", String.valueOf(viewRecentPrivatechatHistory.getTimezone()));
        param.put("not-before", String.valueOf(viewRecentPrivatechatHistory.getNotBefore()));
        return param;
    }

    @Override
    protected String getPath() {
        return "/user/" + viewRecentPrivatechatHistory.getIdOrEmail() + "/history/latest";
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
