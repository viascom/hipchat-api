package ch.viascom.hipchat.api.models.user;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by patrickboesch on 19.04.16.
 */
public enum UserPhotoSize implements Serializable {
    @SerializedName("big")
    BIG("big"),
    @SerializedName("small")
    SMALL("small");

    private final String text;

    UserPhotoSize(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
