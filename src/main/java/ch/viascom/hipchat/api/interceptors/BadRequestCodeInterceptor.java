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
public class BadRequestCodeInterceptor implements FoxHttpResponseInterceptor {

    @Getter
    @Setter
    private int weight = 100;

    private Consumer<FoxHttpResponseInterceptorContext> unauthorizedCodeCallback;

    public BadRequestCodeInterceptor(Consumer<FoxHttpResponseInterceptorContext> unauthorizedCodeCallback) {
        this.unauthorizedCodeCallback = unauthorizedCodeCallback;
    }

    @Override
    public void onIntercept(FoxHttpResponseInterceptorContext context) throws FoxHttpException {
        if (context.getResponseCode() == 400) {
            unauthorizedCodeCallback.accept(context);
        }
    }
}
