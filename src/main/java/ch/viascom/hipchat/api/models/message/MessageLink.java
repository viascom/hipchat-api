package ch.viascom.hipchat.api.models.message;

import ch.viascom.hipchat.api.models.message.links.MessageLinkContent;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by patrickboesch on 21.04.16.
 */
@Data
public class MessageLink {
    private MessageLinkType type;
    private String url;
    @SerializedName(value = "link", alternate = {"image", "video", "link", "twitter_status", "twitter_user"})
    private MessageLinkContent content;
}
