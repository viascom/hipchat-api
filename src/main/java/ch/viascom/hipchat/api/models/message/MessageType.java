package ch.viascom.hipchat.api.models.message;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 20.04.16.
 */
public enum MessageType implements Serializable {
    @SerializedName("message")
    MESSAGE,
    @SerializedName("guest_access")
    GUEST_ACCESS,
    @SerializedName("topic")
    TOPIC,
    @SerializedName("notification")
    NOTIFICATION
}
