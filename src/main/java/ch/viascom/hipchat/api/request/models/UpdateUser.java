package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.user.UserPresence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 19.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser extends CreateUser implements Serializable {
    private UserPresence presence;
}
