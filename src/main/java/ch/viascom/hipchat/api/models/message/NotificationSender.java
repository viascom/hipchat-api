package ch.viascom.hipchat.api.models.message;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
@Data
public class NotificationSender implements Serializable {
    private String id;
    private String type;
}
