package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Member;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.Data;

/**
 * Created by patrickboesch on 19.04.16.
 */
@Data
public class CreateUserResponse implements Response {
    private ResponseHeader responseHeader;
    private String id;
    private String password;
    private Member entity;
}
