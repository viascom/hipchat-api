package ch.viascom.hipchat.api.models.card;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 11.04.16.
 */
public enum CardFormat implements Serializable {
    @SerializedName("compact")
    COMPACT,
    @SerializedName("medium")
    MEDIUM;
}
