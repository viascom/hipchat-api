package ch.viascom.hipchat.api.request.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Nikola Stankovic on 5/6/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPrivatechatMessage {

    /**
     * The id of the message to retrieve
     * Valid length range: 1 - 100.
     */
    @SerializedName("message_id")
    private String messageId;

    /**
     * The id or url encoded name of the room
     * Valid length range: 1 - 100.
     */
    @SerializedName("id_or_name")
    private String idOrName;

    /**
     * Your timezone. Must be a supported timezone.
     * Defaults to 'UTC'.
     */
    private String timezone = "UTC";

    /**
     * Include records about deleted messages into results (body of a message isn't returned). Set to 'true'.
     * Defaults to true.
     */
    @SerializedName("include_deleted")
    private boolean includeDeleted = true;

}
