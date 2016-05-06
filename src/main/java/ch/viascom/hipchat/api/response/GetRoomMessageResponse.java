package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Message;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.Data;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
@Data
public class GetRoomMessageResponse implements Response {
    private ResponseHeader responseHeader;
    private Message message;
}
