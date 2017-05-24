package ch.viascom.hipchat.api.models.card;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
public class CardAttribute implements Serializable {
    private CardAttributeValue value;
    private String label;
}
