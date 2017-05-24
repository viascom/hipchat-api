package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Emoticon;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class GetAllEmoticonsResponse {
    private ArrayList<Emoticon> items;
    private int startIndex;
    private int	maxResults;
}
