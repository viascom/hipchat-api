package ch.viascom.hipchat.api.models.group;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class GroupPlan implements Serializable {
    private int id;
    private GroupPlanType type;
}
