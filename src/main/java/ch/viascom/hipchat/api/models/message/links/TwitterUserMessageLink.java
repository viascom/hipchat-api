package ch.viascom.hipchat.api.models.message.links;

import lombok.Data;

/**
 * Created by patrickboesch on 21.04.16.
 */
@Data
public class TwitterUserMessageLink implements MessageLinkContent {
    private int followers;
    private String name;
    private String profileImageUrl;
    private String screenName;
}
