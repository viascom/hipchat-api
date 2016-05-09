package ch.viascom.hipchat.api.models.capability;

import lombok.Data;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
@Data
public class CapabilityLinks {
    /**
     * The URL to the REST API root.
     */
    private String api;

    /**
     * The URL to human-viewable home page of this integration
     */
    private String homepage;
}
