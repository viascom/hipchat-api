package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.webhook.WebhookAuthentication;
import ch.viascom.hipchat.api.models.webhook.WebhookEvent;
import lombok.Data;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class Webhook {
    private String name;
    private String url;
    private String pattern;
    private WebhookEvent event;
    private WebhookAuthentication authentication = WebhookAuthentication.NONE;
    private String key;
    private int id;
    private String created;
    private Room room;
}
