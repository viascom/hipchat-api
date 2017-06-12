package ch.viascom.hipchat.api.models.room;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by stankovic on 25.05.2017.
 */
public enum RoomRole implements Serializable {
    @SerializedName("room_admin")
    ROOM_ADMIN,
    @SerializedName("room_member")
    ROOM_MEMBER
}
