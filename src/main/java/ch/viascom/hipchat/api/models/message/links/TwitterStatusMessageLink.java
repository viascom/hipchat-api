package ch.viascom.hipchat.api.models.message.links;

import ch.viascom.hipchat.api.models.message.MessageLink;
import lombok.Data;

/**
 * Created by patrickboesch on 21.04.16.
 */
@Data
public class TwitterStatusMessageLink implements MessageLink {
    private String name;
    private String created;
    private String text;
    private String profileImageUrl;
    private String source;
    private String screenName;
}
