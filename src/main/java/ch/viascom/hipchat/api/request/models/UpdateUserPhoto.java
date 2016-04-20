package ch.viascom.hipchat.api.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by patrickboesch on 20.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPhoto {
    private String userId;
    /**
     * The room avatar is a base64 encoded string of a image.
     * Accepted image types are JPEG, PNG and GIF.
     */
    private String photo;
}
