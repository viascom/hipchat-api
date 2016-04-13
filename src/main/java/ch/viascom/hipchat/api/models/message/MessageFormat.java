package ch.viascom.hipchat.api.models.message;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patrickboesch on 11.04.16.
 */
public enum MessageFormat {
    @SerializedName("html")
    HTML,
    @SerializedName("text")
    TEXT;
}
