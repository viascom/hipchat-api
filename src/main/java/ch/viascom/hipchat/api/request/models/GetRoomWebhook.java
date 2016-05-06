package ch.viascom.hipchat.api.request.models;

import lombok.Data;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class GetRoomWebhook {
    private String roomId;
    private String webhookId;
}
