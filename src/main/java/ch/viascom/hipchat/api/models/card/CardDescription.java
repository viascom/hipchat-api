package ch.viascom.hipchat.api.models.card;

import ch.viascom.hipchat.api.models.message.MessageFormat;
import lombok.Data;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
public class CardDescription {
    private String value;
    private MessageFormat format;
}
