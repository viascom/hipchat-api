package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.room.RoomStatistics;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.Data;

/**
 * @author patrick.boesch@umb.ch
 */
@Data
public class GetRoomStatisticsResponse extends RoomStatistics implements Response {
    private ResponseHeader responseHeader;
}
