package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.message.MessageFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 19.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivateMessage implements Serializable {
    private String message;
    private boolean notify = false;
    private MessageFormat message_format = MessageFormat.TEXT;
}
