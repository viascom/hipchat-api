package ch.viascom.hipchat.api.request.models;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 13.04.16.
 */
@Data
public class UpdateRoomAvatar implements Serializable {
    /**
     * The room avatar is a base64 encoded string of a image.
     * Accepted image types are JPEG, PNG and GIF.
     */
    private String avatar;
}
