package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.group.GroupPlan;
import lombok.Data;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class Group {
    private String domain;
    private String name;
    private String created;
    private String avatar_url;
    private GroupPlan plan;
    private Member owner;
    private String subdomain;
    private int id;
}
