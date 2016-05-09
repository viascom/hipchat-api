package ch.viascom.hipchat.api.models.capability;

import lombok.Data;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
@Data
public class CapabilityOauth2Provider {
    /**
     * The OAuth 2 token endpoint for retrieving an access token
     */
    private String tokenUrl;
    /**
     * The OAuth 2 endpoint to direct browsers to in order to receive an authorization code that can be later exchanged using the token URL for an access token
     */
    private String authorizationUrl;
}
