package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.User;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.Data;

/**
 * Created by nikolastankovic on 20.08.2016.
 */
@Data
public class InviteUserToGroupResponse extends User implements Response{
    private ResponseHeader responseHeader;
}
