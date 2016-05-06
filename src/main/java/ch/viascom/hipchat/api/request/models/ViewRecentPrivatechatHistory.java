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
public class ViewRecentPrivatechatHistory {

    /**
     * The id or email of the user
     * Valid length range: 1 - 100.
     */
    @SerializedName("id_or_email")
    private String idOrEmail;

    /**
     * The maximum number of messages to return. Only valid with a non-recent data query.
     * Valid length range: 0 - 1000.
     * Defaults to 100.
     */
    @SerializedName("max-results")
    private int maxResults = 75;

    /**
     * Your timezone. Must be a supported timezone name, please see wikipedia TZ database page
     * Defaults to 'UTC'.
     */
    private String timezone = "UTC";

    /**
     * Include records about deleted messages into results (body of a message isn't returned). Set to 'true'.
     * Defaults to true.
     */
    @SerializedName("include_deleted")
    private boolean includeDeleted = true;

    /**
     * The id of the message that is oldest in the set of messages to be returned.
     * The server will not return any messages that chronologically precede this message.
     */
    @SerializedName("not-before")
    private String notBefore;

    /**
     * Small Constructor
     *
     * @param idOrEmail
     * @param maxResults
     */
    public ViewRecentPrivatechatHistory(String idOrEmail, int maxResults) {
        this.idOrEmail = idOrEmail;
        this.maxResults = maxResults;
    }
}
