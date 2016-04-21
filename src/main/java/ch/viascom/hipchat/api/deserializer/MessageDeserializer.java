package ch.viascom.hipchat.api.deserializer;

import ch.viascom.hipchat.api.models.Message;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by patrickboesch on 21.04.16.
 */
public class MessageDeserializer implements JsonDeserializer<Message> {

    @Override
    public Message deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }

}
