package ch.viascom.hipchat.api.exception;

import ch.viascom.hipchat.api.response.generic.ErrorResponse;

/**
 * Created by patrickboesch on 18.04.16.
 */
public class AuthorizationAPIException extends APIException {
    public AuthorizationAPIException(ErrorResponse errorResponse) {
        super(errorResponse);
    }

    public AuthorizationAPIException(ErrorResponse errorResponse, String message) {
        super(errorResponse, message);
    }
}
