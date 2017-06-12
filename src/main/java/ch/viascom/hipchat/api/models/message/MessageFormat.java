package ch.viascom.hipchat.api.models.message;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 11.04.16.
 */
public enum MessageFormat implements Serializable {
    @SerializedName("html")
    HTML,
    @SerializedName("text")
    TEXT;
}
