package ch.viascom.hipchat.api.exception;

import ch.viascom.hipchat.api.exception.models.ForbiddenError;
import ch.viascom.hipchat.api.response.generic.ErrorResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by patrickboesch on 18.04.16.
 */
public class AccessAPIException extends APIException {
    @Getter
    @Setter
    private ForbiddenError forbiddenError;

    public AccessAPIException(ErrorResponse errorResponse) {
        super(errorResponse);
        forbiddenError = JsonUtil.forbiddenErrorMapper(errorResponse.getResponseBody());
    }

    public AccessAPIException(ErrorResponse errorResponse, String message) {
        super(errorResponse, message);
        forbiddenError = JsonUtil.forbiddenErrorMapper(errorResponse.getResponseBody());
    }
}
