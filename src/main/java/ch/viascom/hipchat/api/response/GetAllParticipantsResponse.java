package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Member;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class GetAllParticipantsResponse implements Serializable {
    private ArrayList<Member> items;
    private int startIndex;
    private int	maxResults;
}
