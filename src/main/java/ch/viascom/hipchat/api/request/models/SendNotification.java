package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.Notification;
import ch.viascom.hipchat.api.models.message.MessageColor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by patrickboesch on 20.04.16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendNotification extends Notification {

    private String roomId;

    public SendNotification(String roomId, String message, MessageColor color, boolean notify) {
        this.roomId = roomId;
        setMessage(message);
        setColor(color);
        setNotify(notify);
    }
}
