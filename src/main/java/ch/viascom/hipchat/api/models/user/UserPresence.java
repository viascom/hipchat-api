package ch.viascom.hipchat.api.models.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class UserPresence implements Serializable {
    private String status;
    private int idle;
    private UserPresenceShow show;
    private UserPresenceClient client;
    @SerializedName("is_online")
    private boolean online;
}
