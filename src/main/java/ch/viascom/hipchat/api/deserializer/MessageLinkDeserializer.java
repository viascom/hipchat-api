package ch.viascom.hipchat.api.deserializer;

import ch.viascom.hipchat.api.models.message.MessageLink;
import ch.viascom.hipchat.api.models.message.MessageLinkType;
import ch.viascom.hipchat.api.models.message.links.*;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by Patrick Bösch on 06.05.16.
 */
public class MessageLinkDeserializer implements JsonDeserializer<MessageLink> {

    @Override
    public MessageLink deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        MessageLink messageLink = new MessageLink();

        MessageLinkType linktype = new Gson().fromJson(jsonElement.getAsJsonObject().getAsJsonPrimitive("type"), MessageLinkType.class);

        MessageLinkContent linkContent = null;

        switch (linktype) {
            case IMAGE:
                linkContent = new Gson().fromJson(jsonElement.getAsJsonObject().getAsJsonObject("image"), ImageMessageLink.class);
                break;
            case LINK:
                linkContent = new Gson().fromJson(jsonElement.getAsJsonObject().getAsJsonObject("link"), LinkMessageLink.class);
                break;
            case TWITTER_STATUS:
                linkContent = new Gson().fromJson(jsonElement.getAsJsonObject().getAsJsonObject("twitter_status"), TwitterStatusMessageLink.class);
                break;
            case TWITTER_USER:
                linkContent = new Gson().fromJson(jsonElement.getAsJsonObject().getAsJsonObject("twitter_user"), TwitterUserMessageLink.class);
                break;
            case VIDEO:
                linkContent = new Gson().fromJson(jsonElement.getAsJsonObject().getAsJsonObject("video"), VideoMessageLink.class);
                break;
        }

        messageLink.setContent(linkContent);
        messageLink.setType(linktype);
        messageLink.setUrl(jsonElement.getAsJsonObject().getAsJsonPrimitive("url").getAsString());

        return messageLink;
    }
}