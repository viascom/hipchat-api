package ch.viascom.hipchat.api.interceptors;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.groundwork.foxhttp.interceptor.response.FoxHttpResponseInterceptor;
import ch.viascom.groundwork.foxhttp.interceptor.response.context.FoxHttpResponseInterceptorContext;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;


/**
 * @author patrick.boesch@viascom.ch
 */
public class NotFoundCodeInterceptor implements FoxHttpResponseInterceptor {

    @Getter
    @Setter
    private int weight = 400;

    private Consumer<FoxHttpResponseInterceptorContext> notFoundCodeCallback;

    public NotFoundCodeInterceptor(Consumer<FoxHttpResponseInterceptorContext> notFoundCodeCallback) {
        this.notFoundCodeCallback = notFoundCodeCallback;
    }

    @Override
    public void onIntercept(FoxHttpResponseInterceptorContext context) throws FoxHttpException {
        if (context.getResponseCode() == 404) {
            notFoundCodeCallback.accept(context);
        }
    }
}
