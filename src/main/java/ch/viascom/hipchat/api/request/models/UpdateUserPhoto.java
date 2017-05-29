package ch.viascom.hipchat.api.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 20.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserPhoto implements Serializable {
    /**
     * The room avatar is a base64 encoded string of a image.
     * Accepted image types are JPEG, PNG and GIF.
     */
    private String photo;
}
