package ch.viascom.hipchat.api.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRoomWebhook {
    private String roomId;
    private String webhookId;
}
