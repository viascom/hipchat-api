package ch.viascom.hipchat.api.models.room;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patrickboesch on 12.04.16.
 */
public enum RoomPrivacy {
    @SerializedName("public")
    PUBLIC,
    @SerializedName("private")
    PRIVATE
}
