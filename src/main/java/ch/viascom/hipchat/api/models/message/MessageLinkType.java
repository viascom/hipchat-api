package ch.viascom.hipchat.api.models.message;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Patrick Bösch on 06.05.16.
 */
public enum MessageLinkType {
    @SerializedName("image")
    IMAGE,
    @SerializedName("video")
    VIDEO,
    @SerializedName("link")
    LINK,
    @SerializedName("twitter_status")
    TWITTER_STATUS,
    @SerializedName("twitter_user")
    TWITTER_USER
}
