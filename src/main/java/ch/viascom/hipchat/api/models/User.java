package ch.viascom.hipchat.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class User extends Member {
    private String xmpp_jid;
    @SerializedName("is_deleted")
    private boolean deleted = false;
    private String last_active;
    private String title;
    private String created;
    private ArrayList<String> roles;
    @SerializedName("is_group_admin")
    private boolean group_admin = false;
    private String timezone;
    @SerializedName("is_guest")
    private boolean guest = false;
    private String email;
    private String photo_url;
}
