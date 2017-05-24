package ch.viascom.hipchat.api.deserializer;

import ch.viascom.groundwork.foxhttp.parser.FoxHttpParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

/**
 * Created by stankovic on 25.05.2017.
 */
public class CustomGsonParser implements FoxHttpParser {

    private Gson gson;

    public CustomGsonParser(GsonBuilder gsonBuilder) {
        this.gson = gsonBuilder.create();
    }

    @Override
    public Serializable serializedToObject(String json, Class<Serializable> type) {
        return gson.fromJson(json, type);
    }

    @Override
    public String objectToSerialized(Serializable o) {
        return gson.toJson(o);
    }
}
