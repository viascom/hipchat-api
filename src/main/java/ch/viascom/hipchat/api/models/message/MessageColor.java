package ch.viascom.hipchat.api.models.message;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 11.04.16.
 */
public enum MessageColor implements Serializable {

    @SerializedName("yellow")
    YELLOW,
    @SerializedName("green")
    GREEN,
    @SerializedName("red")
    RED,
    @SerializedName("purple")
    PURPLE,
    @SerializedName("gray")
    GRAY,
    @SerializedName("random")
    RANDOM;
}

