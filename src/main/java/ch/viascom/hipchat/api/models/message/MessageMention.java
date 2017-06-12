package ch.viascom.hipchat.api.models.message;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 20.04.16.
 */
@Data
@NoArgsConstructor
public class MessageMention implements Serializable {

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
}
