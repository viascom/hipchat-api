package ch.viascom.hipchat.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String roomId;
    private String message;
}
