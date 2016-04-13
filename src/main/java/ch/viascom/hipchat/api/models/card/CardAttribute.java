package ch.viascom.hipchat.api.models.card;

import lombok.Data;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
public class CardAttribute {
    private CardAttributeValue value;
    private String label;
}
