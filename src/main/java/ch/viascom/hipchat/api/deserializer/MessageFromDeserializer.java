package ch.viascom.hipchat.api.deserializer;

import ch.viascom.hipchat.api.models.message.MessageFrom;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by patrickboesch on 21.04.16.
 */
public class MessageFromDeserializer implements JsonDeserializer<MessageFrom> {

    @Override
    public MessageFrom deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        MessageFrom messageFrom = new MessageFrom();
        if (jsonElement.isJsonObject()) {
            messageFrom = new Gson().fromJson(jsonElement, MessageFrom.class);
        } else {
            messageFrom.setName(jsonElement.getAsString());
        }

        return messageFrom;
    }
}
