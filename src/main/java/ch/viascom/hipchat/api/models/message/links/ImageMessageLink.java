package ch.viascom.hipchat.api.models.message.links;

import lombok.Data;

/**
 * Created by patrickboesch on 21.04.16.
 */
@Data
public class ImageMessageLink implements MessageLinkContent {
    private String image;
    private String name;
}
