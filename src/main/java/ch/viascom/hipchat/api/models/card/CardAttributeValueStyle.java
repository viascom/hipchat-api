package ch.viascom.hipchat.api.models.card;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 11.04.16.
 */
public enum CardAttributeValueStyle implements Serializable {
    @SerializedName("lozenge-success")
    LOZENGE_SUCCESS,
    @SerializedName("lozenge-error")
    LOZENGE_ERROR,
    @SerializedName("lozenge-current")
    LOZENGE_CURRENT,
    @SerializedName("lozenge-complete")
    LOZENGE_COMPLETE,
    @SerializedName("lozenge-moved")
    LOZENGE_MOVED,
    @SerializedName("lozenge")
    LOZENGE;

}
