package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Room;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by patrickboesch on 20.04.16.
 */
@Data
public class GetAutoJoinRoomsResponse {
    private ArrayList<Room> items;
    private int startIndex;
    private int	maxResults;
}
