package ch.viascom.hipchat.api.models.message.links;

import ch.viascom.hipchat.api.models.message.MessageLink;
import lombok.Data;

/**
 * Created by patrickboesch on 21.04.16.
 */
@Data
public class LinkMessageLink implements MessageLink {
    private String description;
    private String title;
    private String headerText;
    private String linkText;
    private String faviconUrl;
    private String fullUrl;
}
