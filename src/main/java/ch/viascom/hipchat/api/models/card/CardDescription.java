package ch.viascom.hipchat.api.models.card;

import ch.viascom.hipchat.api.models.message.MessageFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
public class CardDescription implements Serializable {
    private String value;
    private MessageFormat format;
}
