package ch.viascom.hipchat.api.models.user;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class UserPresenceClient implements Serializable {
    private String version;
    private String type;
}
