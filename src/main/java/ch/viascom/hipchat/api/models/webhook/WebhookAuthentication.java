package ch.viascom.hipchat.api.models.webhook;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patrickboesch on 18.04.16.
 */
public enum WebhookAuthentication {
    @SerializedName("jwt")
    JWT,
    @SerializedName("none")
    NONE
}
