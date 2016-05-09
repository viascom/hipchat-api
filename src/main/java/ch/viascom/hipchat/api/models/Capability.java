package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.capability.CapabilityCapabilities;
import ch.viascom.hipchat.api.models.capability.CapabilityLinks;
import ch.viascom.hipchat.api.models.capability.CapabilityVendor;
import lombok.Data;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
@Data
public class Capability {
    /**
     * The vendor that maintains this application
     */
    private CapabilityVendor vendor;

    /**
     * The display name of this application
     */
    private String name;

    /**
     * URLs to retrieve this and related integration information
     */
    private CapabilityLinks links;

    /**
     * The set of capabilities this application supports.
     */
    private CapabilityCapabilities capabilities;

    /**
     * The key that uniquely identifies the application
     */
    private String key;

    /**
     * A short description of this application
     */
    private String description;
}
