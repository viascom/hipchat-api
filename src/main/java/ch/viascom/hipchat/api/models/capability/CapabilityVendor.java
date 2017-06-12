package ch.viascom.hipchat.api.models.capability;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
@Data
public class CapabilityVendor implements Serializable {
    /**
     * The vendor's home page URL
     */
    private String url;

    /**
     * The vendor display name
     */
    private String name;
}
