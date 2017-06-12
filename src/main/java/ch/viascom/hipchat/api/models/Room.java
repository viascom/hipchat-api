package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.room.RoomPrivacy;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 12.04.16.
 */
@Data
public class Room implements Serializable {
    /**
     * Name of the room.
     */
    private String name;

    /**
     * Privacy setting
     * Valid values: public, private.
     */
    private RoomPrivacy privacy = RoomPrivacy.PUBLIC;

    /**
     * Whether the room is visible to delegate admins, may be null to use the group default.
     * May be null.
     */
    @SerializedName("delegate_admin_visibility")
    private boolean delegateAdminVisibility;

    /**
     * Current topic.
     */
    private String topic;

    /**
     * The room owner.
     */
    private Member owner;

    /**
     * Whether or not guests can access this room.
     */
    @SerializedName("is_guest_accessible")
    private boolean guestAccess = false;

    /**
     * Whether or not this room is archived.
     */
    @SerializedName("is_archived")
    private boolean archived;

    /**
     * An etag-like random version string.
     */
    private String version;

    /**
     * ID of the room.
     */
    private int id;

    /**
     * XMPP/Jabber ID of the room.
     */
    @SerializedName("xmpp_jid")
    private String xmppJid;

    /**
     * Time the room was created in ISO 8601 format UTC.
     */
    private String created;

    /**
     * URL to rooms's avatar. 125px on the longest side.
     * May be null.
     */
    @SerializedName("avatar_url")
    private String avatarUrl;

    /**
     * !NOT IN API REFERENCE!
     */
    @SerializedName("last_activ")
    private String lastActiv;

    /**
     * URL for guest access, if enabled.
     * May be null.
     */
    @SerializedName("guest_access_url")
    private String guestAccessUrl;
}
