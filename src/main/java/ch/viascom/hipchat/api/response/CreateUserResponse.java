package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Member;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 19.04.16.
 */
@Data
//TODO: Check what really comes from the api
public class CreateUserResponse implements Serializable {
    private String id;
    private String password;
    private Member entity;
}
