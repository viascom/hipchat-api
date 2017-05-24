package ch.viascom.hipchat.api.request.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Nikola Stankovic on 5/6/16.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewPrivatechatHistory implements Serializable {

    /**
     * The id or email of the user
     * Valid length range: 1 - 100.
     */
    @SerializedName("id_or_email")
    private String idOrEmail;

    /**
     * The offset for the messages to return. Only valid with a non-recent data query.
     * Defaults to 0.
     */
    @SerializedName("start-index")
    private int startIndex = 0;

    /**
     * The maximum number of messages to return. Only valid with a non-recent data query.
     * Valid length range: 0 - 1000.
     * Defaults to 100.
     */
    @SerializedName("max-results")
    private int maxResults = 100;

    /**
     * Reverse the output such that the oldest message is first. For consistent paging, set to 'false'.
     * Defaults to true.
     */
    private boolean reverse = true;

    /**
     * Include records about deleted messages into results (body of a message isn't returned). Set to 'true'.
     * Defaults to true.
     */
    @SerializedName("include_deleted")
    private boolean includeDeleted = true;

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
    private String timezone = "UTC";

    /**
     * Either the earliest date to fetch history for the ISO-8601 format, or 'null' to disable this filter.
     */
    @SerializedName("end-date")
    private String endDate;

    /**
     * Small Constructor
     *
     * @param idOrEmail
     * @param startIndex
     * @param maxResults
     */
    public ViewPrivatechatHistory(String idOrEmail, int startIndex, int maxResults) {
        this.idOrEmail = idOrEmail;
        this.startIndex = startIndex;
        this.maxResults = maxResults;
    }
}
