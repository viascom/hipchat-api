package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.message.MessageColor;
import ch.viascom.hipchat.api.models.message.MessageFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification{
    private String roomId;
    private String from;
    private MessageFormat message_format;
    private MessageColor color;
    private String attach_to;
    private boolean notify;
    private String message;
    private Card card;

    public Notification(String roomId, String message,MessageColor color,boolean notify){
        this.roomId = roomId;
        this.message = message;
        this.color = color;
        this.notify = notify;
    }
}
