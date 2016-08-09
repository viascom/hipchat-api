package ch.viascom.hipchat.api.models.message;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by patrickboesch on 20.04.16.
 */
@Data
@NoArgsConstructor
public class MessageMention {
    private int id;
    private String mention_name;
    private String name;
    private String version;
}
