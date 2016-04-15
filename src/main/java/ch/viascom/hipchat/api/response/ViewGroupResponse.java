package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Group;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.Data;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class ViewGroupResponse extends Group implements Response {
    private ResponseHeader responseHeader;
}
