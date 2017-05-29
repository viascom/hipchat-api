package ch.viascom.hipchat.api.exception;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;

/**
 * @author patrick.boesch@viascom.ch
 */
public class HipChatAPIException extends FoxHttpException {

    public HipChatAPIException(Throwable cause) {
        super(cause);
    }

    public HipChatAPIException(String message) {
        super(message);
    }

    public HipChatAPIException(String message, Throwable cause) {
        super(message, cause);
    }
}
