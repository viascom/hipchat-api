package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.user.UserPresence;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class User extends Member implements Serializable {
    /**
     * XMPP/Jabber ID of the user.
     */
    @SerializedName("xmpp_jid")
    private String xmppJid;

    /**
     * Whether the user has been deleted or not.
     */
    @SerializedName("is_deleted")
    private boolean deleted = false;

    /**
     * The date in ISO-8601 when the user was last active
     * May be null.
     */
    @SerializedName("last_active")
    private String lastActive;

    /**
     * User's title
     */
    private String title;

    /**
     * Presence information for the user
     * May be null.
     */
    private UserPresence presence;

    /**
     * The date in ISO-8601 when the user was created
     */
    private String created;

    /**
     * The list of roles for the user
     */
    private ArrayList<String> roles;

    /**
     * Whether or not this user is an admin of the group.
     * Defaults to false.
     */
    @SerializedName("is_group_admin")
    private boolean groupAdmin = false;

    /**
     * The desired user timezone
     */
    private String timezone;

    /**
     * Whether or not this user is a guest or registered user.
     * Defaults to false.
     */
    @SerializedName("is_guest")
    private boolean guest = false;

    /**
     * User's email
     * May be null.
     */
    private String email;

    /**
     * URL to user's photo. 125px on the longest side.
     * May be null.
     */
    @SerializedName("photo_url")
    private String photoUrl;
}
