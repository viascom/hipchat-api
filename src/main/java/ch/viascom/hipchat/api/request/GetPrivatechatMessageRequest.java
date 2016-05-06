package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.deserializer.MessageFromDeserializer;
import ch.viascom.hipchat.api.deserializer.MessageLinkDeserializer;
import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.models.message.MessageFrom;
import ch.viascom.hipchat.api.models.message.MessageLink;
import ch.viascom.hipchat.api.request.generic.GetRequest;
import ch.viascom.hipchat.api.request.models.GetPrivatechatMessage;
import ch.viascom.hipchat.api.response.GetPrivatechatMessageResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/**
 * Created by Nikola Stankovic on 5/6/16.
 */
public class GetPrivatechatMessageRequest extends GetRequest<GetPrivatechatMessageResponse> {

    private GetPrivatechatMessage getPrivatechatMessage;

    public GetPrivatechatMessageRequest(GetPrivatechatMessage getPrivatechatMessage, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) throws APIException {
        super(accessToken, baseUrl, httpClient, executorService);
        this.getPrivatechatMessage = getPrivatechatMessage;
        setQueryParams(new ArrayList<>(Arrays.asList("timezone", "includeDeleted")), getPrivatechatMessage);
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

    @Override
    protected String getPath() {
        return "/user/" + getPrivatechatMessage.getIdOrName() + "/history/" + getPrivatechatMessage.getMessageId();
    }
}
