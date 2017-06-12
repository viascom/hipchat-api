package ch.viascom.hipchat.api.models.room;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author patrick.boesch@viascom.ch
 */
@Data
public class RoomStatistics implements Serializable {
    /**
     * The number of messages sent in this room for its entire history.
     */
    @SerializedName("messages_sent")
    private int messagesSent;

    /**
     * Time of last activity (sent message) in the room in UNIX time (UTC). May be null in rare cases when the time is unknown.
     * May be null.
     */
    @SerializedName("last_active")
    private String lastActive;
}
