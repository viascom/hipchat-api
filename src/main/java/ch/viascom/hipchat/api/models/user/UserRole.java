package ch.viascom.hipchat.api.models.user;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 19.04.16.
 */
public enum UserRole implements Serializable {
    @SerializedName("owner")
    OWNER,
    @SerializedName("admin")
    ADMIN,
    @SerializedName("moderator")
    MODERATOR,
    @SerializedName("user")
    USER
}
