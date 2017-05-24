package ch.viascom.hipchat.api.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Patrick Bösch on 06.05.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InviteUser implements Serializable {
    /**
     * The id, email address, or mention name (beginning with an '@') of the user to invite
     * Valid length range: 1 - 100.
     */
    private String user_id_or_email;

    /**
     * The id or url encoded name of the room
     * Valid length range: 1 - 100.
     */
    private String room_id_or_name;

    /**
     * The reason to give to the invited user
     * Valid length range: 1 - 250.
     */
    private String reason;
}
