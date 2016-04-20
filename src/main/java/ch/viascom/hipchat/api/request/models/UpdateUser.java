package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.user.UserPresence;
import lombok.Data;

/**
 * Created by patrickboesch on 19.04.16.
 */
@Data
public class UpdateUser extends CreateUser {
    private String userId;
    private UserPresence presence;
}
