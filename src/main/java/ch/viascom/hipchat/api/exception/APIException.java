package ch.viascom.hipchat.api.exception;

import ch.viascom.hipchat.api.response.generic.ErrorResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by patrickboesch on 14.04.16.
 */
public class APIException extends Exception {
    @Getter
    @Setter
    private ErrorResponse errorResponse;

    public APIException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public APIException(ErrorResponse errorResponse, String message) {
        super(message);
        this.errorResponse = errorResponse;
    }
}
