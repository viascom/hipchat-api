package ch.viascom.hipchat.api.models.card;

import lombok.Data;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
public class CardAttributeValue {
    private String url;
    private CardAttributeValueStyle style;
    private String label;
    private CardIcon icon;
}
