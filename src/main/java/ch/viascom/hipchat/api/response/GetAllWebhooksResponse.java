package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Webhook;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class GetAllWebhooksResponse  implements Response {
    private ResponseHeader responseHeader;
    private ArrayList<Webhook> items;
    private int startIndex;
    private int	maxResults;
}
