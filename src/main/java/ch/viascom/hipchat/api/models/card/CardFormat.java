package ch.viascom.hipchat.api.models.card;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patrickboesch on 11.04.16.
 */
public enum CardFormat {
    @SerializedName("compact")
    COMPACT,
    @SerializedName("medium")
    MEDIUM;
}
