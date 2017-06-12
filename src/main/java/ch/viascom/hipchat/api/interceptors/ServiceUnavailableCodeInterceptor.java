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
public class ServiceUnavailableCodeInterceptor implements FoxHttpResponseInterceptor {

    @Getter
    @Setter
    private int weight = 800;

    private Consumer<FoxHttpResponseInterceptorContext> serviceUnavailableCodeCallback;

    public ServiceUnavailableCodeInterceptor(Consumer<FoxHttpResponseInterceptorContext> serviceUnavailableCodeCallback) {
        this.serviceUnavailableCodeCallback = serviceUnavailableCodeCallback;
    }

    @Override
    public void onIntercept(FoxHttpResponseInterceptorContext context) throws FoxHttpException {
        if (context.getResponseCode() == 503) {
            serviceUnavailableCodeCallback.accept(context);
        }
    }
}
