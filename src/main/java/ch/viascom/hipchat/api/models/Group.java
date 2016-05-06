package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.group.GroupPlan;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class Group {
    /**
     * The Google Apps domain, if applicable
     * May be null.
     */
    private String domain;

    /**
     * Group name
     */
    private String name;

    /**
     * The date in ISO-8601 when the group was created
     */
    private String created;

    /**
     * URL to group's avatar. 125px on the longest side.
     * May be null.
     */
    @SerializedName("avatar_url")
    private String avatarUrl;

    /**
     * Presence information for the user
     */
    private GroupPlan plan;

    /**
     * The group owner.
     */
    private Member owner;

    /**
     * The name used as the prefix to the HipChat domain
     */
    private String subdomain;

    /**
     * Group ID
     */
    private int id;
}
