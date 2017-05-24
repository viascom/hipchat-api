package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.room.RoomRole;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Nikola Stankovic on 20.04.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMember implements Serializable {
    @SerializedName("room_roles")
    private ArrayList<RoomRole> roomRoles;
}
