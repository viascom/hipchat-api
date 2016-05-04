package ch.viascom.hipchat.api.request.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewRoomHistory {
    /**
     * The id or url encoded name of the room.
     * Valid length range: 1 - 100.
     */
    private String roomId;

    /**
     * The offset for the messages to return. Only valid with a non-recent data query.
     * Defaults to 0.
     */
    @SerializedName("start-index")
    private int	start_index = 0;

    /**
     * The maximum number of messages to return. Only valid with a non-recent data query.
     * Valid length range: 0 - 1000.
     * Defaults to 100.
     */
    @SerializedName("max-results")
    private int	max_results = 100;

    /**
     * Reverse the output such that the oldest message is first. For consistent paging, set to 'false'.
     * Defaults to true.
     */
    private boolean reverse = true;

    /**
     * Include records about deleted messages into results (body of a message isn't returned). Set to 'true'.
     * Defaults to true.
     */
    private boolean include_deleted = true;

    /**
     * Either the latest date to fetch history for in ISO-8601 format, or 'recent' to fetch the latest 75 messages.
     * Paging isn't supported for 'recent', however they are real-time values, whereas date queries may not
     * include the most recent messages.
     * Defaults to 'recent'.
     */
    private String date = "recent";

    /**
     * Your timezone. Must be a supported timezone name, please see wikipedia TZ database page
     * Defaults to 'UTC'.
     */
    private String timezone = "UTZ";

    /**
     * Either the earliest date to fetch history for the ISO-8601 format, or 'null' to disable this filter.
     */
    @SerializedName("end-date")
    private String end_date;
}
