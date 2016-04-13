package ch.viascom.hipchat.api.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class JsonUtil {

    public static String getJsonBody(Object o) {
        Gson gson;
        GsonBuilder gb = new GsonBuilder();
        gson = gb.create();
        String json = gson.toJson(o);

        //Replace roomId from body
        json = json.replaceAll("\"roomId\":\"(\\w+)\",", "");

        return json;
    }
}
