package ch.viascom.hipchat.api.request.models;

import lombok.Data;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
@Data
public class GetRoomMessage {
    /**
     * The id or url encoded name of the room.
     * Valid length range: 1 - 100.
     */
    private String roomId;
    /**
     * The id of the message to retrieve
     * Valid length range: 1 - 100.
     */
    private String messageId;

    /**
     * Include records about deleted messages into results (body of a message isn't returned). Set to 'true'.
     * Defaults to true.
     */
    private boolean include_deleted = true;

    /**
     * Your timezone. Must be a supported timezone name, please see wikipedia TZ database page
     * Defaults to 'UTC'.
     */
    private String timezone = "UTZ";
}
