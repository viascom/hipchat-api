package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Message;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
@Data
public class ViewRecentRoomHistoryResponse {
    private ArrayList<Message> items;
    private int startIndex;
    private int maxResults;
}
