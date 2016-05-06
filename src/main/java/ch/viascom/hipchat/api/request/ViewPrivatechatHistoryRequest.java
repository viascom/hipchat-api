package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.deserializer.MessageFromDeserializer;
import ch.viascom.hipchat.api.deserializer.MessageLinkDeserializer;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.models.message.MessageFrom;
import ch.viascom.hipchat.api.models.message.MessageLink;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.ViewPrivatechatHistory;
import ch.viascom.hipchat.api.response.ViewPrivatechatHistoryResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by Nikola Stankovic on 5/6/16.
 */
public class ViewPrivatechatHistoryRequest extends GetRequest<ViewPrivatechatHistoryResponse> {
    private ViewPrivatechatHistory viewPrivatechatHistory;

    public ViewPrivatechatHistoryRequest(ViewPrivatechatHistory viewPrivatechatHistory, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.viewPrivatechatHistory = viewPrivatechatHistory;
        setQueryParams(new ArrayList<>(Arrays.asList("startIndex", "maxResults", "reverse", "includeDeleted", "date", "timezone", "endDate")), viewPrivatechatHistory);
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
        gsonBuilder.registerTypeAdapter(MessageLink.class, new MessageLinkDeserializer());
        Gson gson = gsonBuilder.create();

        return gson;
    }
}
