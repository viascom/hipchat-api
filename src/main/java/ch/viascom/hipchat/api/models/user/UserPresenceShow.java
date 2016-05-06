package ch.viascom.hipchat.api.models.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patrickboesch on 18.04.16.
 */
public enum UserPresenceShow {
    @SerializedName("away")
    AWAY,
    @SerializedName("chat")
    CHAT,
    @SerializedName("dnd")
    DND,
    @SerializedName("xa")
    XA
}
