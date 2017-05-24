package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.user.UserPresence;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 19.04.16.
 */
@Data
public class UpdateUser extends CreateUser implements Serializable {
    private String userId;
    private UserPresence presence;
}
