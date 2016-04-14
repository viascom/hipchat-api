package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.models.Member;
import ch.viascom.hipchat.api.models.Room;
import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by patrickboesch on 13.04.16.
 */
@Data
public class GetRoomResponse extends Room implements Response {
    private ResponseHeader responseHeader;
    private String xmpp_jid;
    private String created;
    private boolean is_archived;
    private String avatar_url;

    @SerializedName("is_guest_accessible")
    private boolean guest_access;

    private Member owner;
    private String version;
    private String id;
    private String guest_access_url;

    private ArrayList<Member> participants;
}
