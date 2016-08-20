package ch.viascom.hipchat.api.util;

import ch.viascom.hipchat.api.exception.models.ForbiddenError;
import ch.viascom.hipchat.api.exception.models.ForbiddenErrorWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by patrickboesch on 12.04.16.
 */
public class JsonUtil {

    public static String getJsonBody(Object o) {
        return getJsonBody(o, "roomId");
    }

    public static String getJsonBody(Object o, String pathIdName) {
        Gson gson;
        GsonBuilder gb = new GsonBuilder();
        gson = gb.create();
        String json = gson.toJson(o);

        //Replace pathIdName from body
        json = json.replaceAll("\"" + pathIdName + "\"\\:[^\\,\\}]*,", "");

        return json;
    }

    public static ForbiddenError forbiddenErrorMapper(String errorBody) {
        Gson gson = new Gson();
        ForbiddenErrorWrapper wrapper = gson.fromJson(errorBody, ForbiddenErrorWrapper.class);
        return wrapper.getError();
    }
}
