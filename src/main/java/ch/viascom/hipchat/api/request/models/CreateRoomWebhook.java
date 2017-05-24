package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.webhook.WebhookAuthentication;
import ch.viascom.hipchat.api.models.webhook.WebhookEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomWebhook implements Serializable {
    private String roomId;
    private String key;
    private String name;
    private String url;
    private String pattern;
    private WebhookEvent event;
    private WebhookAuthentication authentication = WebhookAuthentication.NONE;
}
