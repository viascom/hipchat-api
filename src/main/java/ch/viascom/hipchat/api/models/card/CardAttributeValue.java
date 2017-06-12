package ch.viascom.hipchat.api.models.card;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
public class CardAttributeValue implements Serializable {
    private String url;
    private CardAttributeValueStyle style;
    private String label;
    private CardIcon icon;
}
