package ch.viascom.hipchat.api.request.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewRecentRoomHistory implements Serializable {
    /**
     * The id or url encoded name of the room.
     * Valid length range: 1 - 100.
     */
    private String roomId;

    /**
     * The maximum number of messages to return. Only valid with a non-recent data query.
     * Valid length range: 0 - 1000.
     * Defaults to 75.
     */
    @SerializedName("max-results")
    private int max_results = 75;

    /**
     * Include records about deleted messages into results (body of a message isn't returned). Set to 'true'.
     * Defaults to true.
     */
    private boolean include_deleted = true;

    /**
     * Your timezone. Must be a supported timezone name, please see wikipedia TZ database page
     * Defaults to 'UTC'.
     */
    private String timezone = "UTC";

    /**
     * The id of the message that is oldest in the set of messages to be returned. The server will not return any messages that chronologically precede this message.
     */
    @SerializedName("not-before")
    private String not_before;
}
