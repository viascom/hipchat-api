package ch.viascom.hipchat.api.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by nikolastankovic on 20.08.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InviteUserToGroup implements Serializable {
    private String title;
    private String email;
    private String name;
}
