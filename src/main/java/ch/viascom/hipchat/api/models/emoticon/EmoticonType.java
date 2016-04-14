package ch.viascom.hipchat.api.models.emoticon;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patrickboesch on 14.04.16.
 */
public enum EmoticonType {
    @SerializedName("global")
    GLOBAL,
    @SerializedName("group")
    GROUP,
    @SerializedName("all")
    ALL
}
