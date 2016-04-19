package ch.viascom.hipchat.api.request.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by patrickboesch on 19.04.16.
 */
@Data
public class CreateUser {
    private String name;
    private ArrayList<String> roles;
    private String title;
    private String mention_name;
    @SerializedName("is_group_admin")
    private boolean group_admin = false;
    private String timezone = "UTC";
    private String password;
    private String email;
}
