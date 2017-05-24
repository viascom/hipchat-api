package ch.viascom.hipchat.api.request.models;

import ch.viascom.hipchat.api.models.user.UserRole;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by patrickboesch on 19.04.16.
 */
@Data
public class CreateUser implements Serializable {
    private String name;
    private ArrayList<UserRole> roles = new ArrayList<>();
    private String title;
    private String mention_name;
    @SerializedName("is_group_admin")
    private boolean group_admin = false;
    private String timezone = "UTC";
    private String password;
    private String email;
}
