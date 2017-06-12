package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Message;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Nikola Stankovic on 5/6/16.
 */
@Data
public class ViewPrivatechatHistoryResponse implements Serializable {
    private ArrayList<Message> items;
    private int startIndex;
    private int maxResults;
}
