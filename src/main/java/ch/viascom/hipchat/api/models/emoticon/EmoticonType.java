package ch.viascom.hipchat.api.models.emoticon;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 14.04.16.
 */
public enum EmoticonType implements Serializable {
    @SerializedName("global")
    GLOBAL("global"),
    @SerializedName("group")
    GROUP("group"),
    @SerializedName("all")
    ALL("all");

    private final String text;

    EmoticonType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
