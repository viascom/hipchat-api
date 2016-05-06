package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Room;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.Data;

/**
 * Created by patrickboesch on 13.04.16.
 */
@Data
public class GetRoomResponse extends Room implements Response {
    private ResponseHeader responseHeader;
    private Room room;
}
