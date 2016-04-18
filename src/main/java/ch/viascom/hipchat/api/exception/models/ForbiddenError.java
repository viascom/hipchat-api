package ch.viascom.hipchat.api.exception.models;

import lombok.Data;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class ForbiddenError {
    private String message;
    private int code;
    private String type;
}
