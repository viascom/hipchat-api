package ch.viascom.hipchat.api.models.card;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 11.04.16.
 */
public enum CardStyle implements Serializable {
    @SerializedName("file")
    FILE,
    @SerializedName("image")
    IMAGE,
    @SerializedName("application")
    APPLICATION,
    @SerializedName("link")
    LINK,
    @SerializedName("media")
    MEDIA;
}
