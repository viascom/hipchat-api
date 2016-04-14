package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import ch.viascom.hipchat.api.response.models.GetAllRoomsResponseItem;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by patrickboesch on 12.04.16.
 */
@Data
public class GetAllRoomsResponse implements Response {
    private ResponseHeader responseHeader;
    private ArrayList<GetAllRoomsResponseItem> items;
    private int startIndex;
    private int	maxResults;
}
