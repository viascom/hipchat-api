package ch.viascom.hipchat.api.models;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
@Data
public class HipChatScope implements Serializable {
    /**
     *
     */
    private String name;

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String description;
}
