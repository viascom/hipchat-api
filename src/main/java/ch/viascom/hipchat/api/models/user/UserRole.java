package ch.viascom.hipchat.api.models.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patrickboesch on 19.04.16.
 */
public enum UserRole {
    @SerializedName("owner")
    OWNER,
    @SerializedName("admin")
    ADMIN,
    @SerializedName("moderator")
    MODERATOR,
    @SerializedName("user")
    USER
}
