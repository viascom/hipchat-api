package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.Room;
import ch.viascom.hipchat.api.models.room.RoomOwner;
import lombok.Data;

/**
 * Created by patrickboesch on 12.04.16.
 */
@Data
public class UpdateRoom extends Room {
    private boolean is_archived = false;
    private RoomOwner owner;

}
