package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.room.RoomPrivacy;
import lombok.Data;

/**
 * Created by patrickboesch on 12.04.16.
 */
@Data
public class Room {
    private String name;
    private RoomPrivacy privacy = RoomPrivacy.PUBLIC;
    private boolean delegate_admin_visibility;
    private String topic;
    private String owner_user_id;
    private boolean guest_access = false;
}
