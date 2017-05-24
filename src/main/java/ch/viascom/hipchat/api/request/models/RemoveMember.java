package ch.viascom.hipchat.api.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Nikola Stankovic on 06.05.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveMember implements Serializable {

    /**
     * The id, email address, or mention name (beginning with an '@') of the user.
     * !IMPORTANT! Only the id is supported by hipchat-api.
     */
    private int userId;

    /**
     * The id or url encoded name of the room.
     * Valid length range: 1 - 100.
     */
    private String roomId;
}

