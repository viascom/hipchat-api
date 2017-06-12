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
public class MethodNotAllowedCodeInterceptor implements FoxHttpResponseInterceptor {

    @Getter
    @Setter
    private int weight = 500;

    private Consumer<FoxHttpResponseInterceptorContext> methodNotAllowedCodeCallback;

    public MethodNotAllowedCodeInterceptor(Consumer<FoxHttpResponseInterceptorContext> methodNotAllowedCodeCallback) {
        this.methodNotAllowedCodeCallback = methodNotAllowedCodeCallback;
    }

    @Override
    public void onIntercept(FoxHttpResponseInterceptorContext context) throws FoxHttpException {
        if (context.getResponseCode() == 405) {
            methodNotAllowedCodeCallback.accept(context);
        }
    }
}
