package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Created by Nikola Stankovic on 20.04.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMember {
    private int userId;
    private String roomId;
    private ArrayList<UserRole> room_roles;
}
