package ch.viascom.hipchat.api.request.models;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class GetRoomWebhook implements Serializable {
    private String roomId;
    private String webhookId;
}
