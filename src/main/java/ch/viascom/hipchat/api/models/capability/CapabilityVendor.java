package ch.viascom.hipchat.api.models.capability;

import lombok.Data;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
@Data
public class CapabilityVendor {
    /**
     * The vendor's home page URL
     */
    private String url;

    /**
     * The vendor display name
     */
    private String name;
}
