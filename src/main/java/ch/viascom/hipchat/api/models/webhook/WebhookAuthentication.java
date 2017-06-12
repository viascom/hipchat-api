package ch.viascom.hipchat.api.models.webhook;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 18.04.16.
 */
public enum WebhookAuthentication implements Serializable {
    @SerializedName("jwt")
    JWT,
    @SerializedName("none")
    NONE
}
