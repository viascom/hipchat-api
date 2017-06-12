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
public class InternalServerErrorCodeInterceptor implements FoxHttpResponseInterceptor {

    @Getter
    @Setter
    private int weight = 700;

    private Consumer<FoxHttpResponseInterceptorContext> internalServerErrorCodeCallback;

    public InternalServerErrorCodeInterceptor(Consumer<FoxHttpResponseInterceptorContext> internalServerErrorCodeCallback) {
        this.internalServerErrorCodeCallback = internalServerErrorCodeCallback;
    }

    @Override
    public void onIntercept(FoxHttpResponseInterceptorContext context) throws FoxHttpException {
        if (context.getResponseCode() == 500) {
            internalServerErrorCodeCallback.accept(context);
        }
    }
}
