package ch.viascom.hipchat.api.models.message;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
@Data
@NoArgsConstructor
public class MessageFrom {
    /**
     * The user ID
     */
    private int id;

    /**
     * User's @mention name
     */
    @SerializedName("mention_name")
    private String mentionName;

    /**
     * The display user name
     */
    private String name;

    /**
     * An etag-like random version string.
     */
    private String version;

    public MessageFrom(String name){
        this.name = name;
    }
}
