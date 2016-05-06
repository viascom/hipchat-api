package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Message;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by Nikola Stankovic on 5/6/16.
 */
@Data
public class ViewRecentPrivatechatHistoryResponse implements Response {
    private ResponseHeader responseHeader;
    private ArrayList<Message> items;
    private int startIndex;
    private int maxResults;
}
