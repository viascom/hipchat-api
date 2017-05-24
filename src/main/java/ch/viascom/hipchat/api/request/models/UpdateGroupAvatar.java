package ch.viascom.hipchat.api.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 15.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGroupAvatar implements Serializable {
    private String groupId;
    /**
     * The group avatar is a base64 encoded string of a image.
     * Accepted image types are JPEG, PNG and GIF.
     */
    private String avatar;
}
