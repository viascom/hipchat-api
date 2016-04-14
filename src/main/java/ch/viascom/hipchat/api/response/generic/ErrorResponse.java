package ch.viascom.hipchat.api.response.generic;

import lombok.Data;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class ErrorResponse implements Response {
    private ResponseHeader responseHeader;
    private String errorMessage;
    private String requestBody;
    private String responseBody;
}
