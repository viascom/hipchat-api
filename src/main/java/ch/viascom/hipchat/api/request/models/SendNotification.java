package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.Notification;
import ch.viascom.hipchat.api.models.message.MessageColor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 20.04.16.
 */
@Data
@NoArgsConstructor
public class SendNotification extends Notification implements Serializable {

    public SendNotification(String message, MessageColor color, boolean notify) {
        setMessage(message);
        setColor(color);
        setNotify(notify);
    }
}
