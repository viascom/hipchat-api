package ch.viascom.hipchat.api.deserializer;

import ch.viascom.hipchat.api.models.message.MessageFrom;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by patrickboesch on 21.04.16.
 */
public class MessageFromDeserializer implements JsonDeserializer<MessageFrom> {

    @Override
    public MessageFrom deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        MessageFrom messageFrom = new MessageFrom();
        if(jsonElement.isJsonObject()){
            messageFrom.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
            messageFrom.setName(jsonElement.getAsJsonObject().get("name").getAsString());
            messageFrom.setMention_name(jsonElement.getAsJsonObject().get("mention_name").getAsString());
            messageFrom.setVersion(jsonElement.getAsJsonObject().get("version").getAsString());
        } else {
            messageFrom.setName(jsonElement.getAsString());
        }
        return messageFrom;
    }

}
