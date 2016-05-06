package ch.viascom.hipchat.api.models.message;

import lombok.Data;

/**
 * Created by patrickboesch on 21.04.16.
 */
@Data
public class MessageFile {
    private String url;
    private String thumb_url;
    private String name;
    private int size;
}
