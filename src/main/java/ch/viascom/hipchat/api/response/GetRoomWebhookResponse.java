package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Webhook;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.Data;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class GetRoomWebhookResponse extends Webhook implements Response {
    private ResponseHeader responseHeader;
}
