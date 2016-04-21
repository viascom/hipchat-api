package ch.viascom.hipchat.api.models.message.links;

import ch.viascom.hipchat.api.models.message.MessageLink;
import lombok.Data;

/**
 * Created by patrickboesch on 21.04.16.
 */
@Data
public class ImageMessageLink implements MessageLink {
    private String image;
    private String name;
}
