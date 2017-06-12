package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Emoticon;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class GetAllEmoticonsResponse implements Serializable {
    private ArrayList<Emoticon> items;
    private int startIndex;
    private int	maxResults;
}
