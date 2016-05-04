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
public class SetTopic {
    private String roomId;
    private String topic;
}
