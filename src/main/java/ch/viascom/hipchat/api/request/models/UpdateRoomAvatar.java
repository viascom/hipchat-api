package ch.viascom.hipchat.api.request.models;

import lombok.Data;

/**
 * Created by patrickboesch on 13.04.16.
 */
@Data
public class UpdateRoomAvatar {
    /**
     * The room avatar is a base64 encoded string of a image.
     * Accepted image types are JPEG, PNG and GIF.
     */
    private String avatar;
}
