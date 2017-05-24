package ch.viascom.hipchat.api.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 20.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessage implements Serializable {
    private String roomId;
    private String message;
}
