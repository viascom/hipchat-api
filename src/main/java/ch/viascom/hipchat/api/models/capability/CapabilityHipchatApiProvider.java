package ch.viascom.hipchat.api.models.capability;

import ch.viascom.hipchat.api.models.HipChatScope;
import lombok.Data;

import java.util.HashMap;

/**
 * Created by Patrick Bösch on 09.05.16.
 */
@Data
public class CapabilityHipchatApiProvider {
    /**
     * The base URL for the API
     */
    private String url;

    /**
     * The scopes that this API supports.
     */
    private HashMap<String, HipChatScope> availableScopes;
}
