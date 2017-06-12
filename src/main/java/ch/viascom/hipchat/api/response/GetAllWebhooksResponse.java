package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Webhook;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class GetAllWebhooksResponse implements Serializable {
    private ArrayList<Webhook> items;
    private int startIndex;
    private int	maxResults;
}
