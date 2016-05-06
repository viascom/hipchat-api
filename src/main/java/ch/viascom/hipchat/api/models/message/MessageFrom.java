package ch.viascom.hipchat.api.models.message;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
@Data
@NoArgsConstructor
public class MessageFrom {
    private int id;
    private String mention_name;
    private String name;
    private String version;

    public MessageFrom(String name){
        this.name = name;
    }
}
