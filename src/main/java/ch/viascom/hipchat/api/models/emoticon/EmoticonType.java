package ch.viascom.hipchat.api.models.emoticon;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 14.04.16.
 */
public enum EmoticonType implements Serializable {
    @SerializedName("global")
    GLOBAL,
    @SerializedName("group")
    GROUP,
    @SerializedName("all")
    ALL
}
