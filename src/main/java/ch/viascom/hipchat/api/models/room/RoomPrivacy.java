package ch.viascom.hipchat.api.models.room;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 12.04.16.
 */
public enum RoomPrivacy implements Serializable {
    @SerializedName("public")
    PUBLIC,
    @SerializedName("private")
    PRIVATE
}
