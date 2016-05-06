package ch.viascom.hipchat.api.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by patrickboesch on 12.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyMessage{
    private String roomId;
    private String message;
    private String parentMessageId;
}
