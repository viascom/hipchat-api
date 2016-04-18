package ch.viascom.hipchat.api.models.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class UserPresence {
    private String status;
    private int idle;
    private UserPresenceShow show;
    private UserPresenceClient client;
    @SerializedName("is_online")
    private boolean online;
}
