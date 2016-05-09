package ch.viascom.hipchat.api.models.capability;

import lombok.Data;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
@Data
public class CapabilityCapabilities {
    /**
     * The capability of providing and accepting OAuth 2 tokens for authentication
     */
    private CapabilityOauth2Provider oauth2Provider;

    /**
     * The ability to provide the HipChat API
     */
    private CapabilityHipchatApiProvider hipchatApiProvider;
}
