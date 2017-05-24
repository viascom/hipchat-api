package ch.viascom.hipchat.api.interceptors;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.groundwork.foxhttp.header.FoxHttpHeader;
import ch.viascom.groundwork.foxhttp.interceptor.response.FoxHttpResponseInterceptor;
import ch.viascom.groundwork.foxhttp.interceptor.response.context.FoxHttpResponseInterceptorContext;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.function.BiConsumer;

/**
 * @author patrick.boesch@viascom.ch
 */
public class TooManyRequestsCodeInterceptor implements FoxHttpResponseInterceptor {

    @Getter
    @Setter
    private int weight = 600;

    private BiConsumer<FoxHttpResponseInterceptorContext, FoxHttpHeader> tooManyRequestsCodeCallback;

    @Getter
    private ArrayList<String> rateLimitHeaderNames = new ArrayList<>();


    public TooManyRequestsCodeInterceptor(BiConsumer<FoxHttpResponseInterceptorContext, FoxHttpHeader> tooManyRequestsCodeCallback) {
        this.tooManyRequestsCodeCallback = tooManyRequestsCodeCallback;

        //Set headers from API rate limits
        rateLimitHeaderNames.add("X-Ratelimit-Limit");
        rateLimitHeaderNames.add("X-Ratelimit-Remaining");
        rateLimitHeaderNames.add("X-Ratelimit-Reset");
        rateLimitHeaderNames.add("X-FloodControl-Limit");
        rateLimitHeaderNames.add("X-FloodControl-Remaining");
        rateLimitHeaderNames.add("X-FloodControl-Reset");

    }

    @Override
    public void onIntercept(FoxHttpResponseInterceptorContext context) throws FoxHttpException {
        if (context.getResponseCode() == 429) {

            FoxHttpHeader limitHeaders = new FoxHttpHeader();

            context.getFoxHttpResponse().getResponseHeaders().getHeaderEntries()
                    .stream()
                    .filter(headerEntry -> rateLimitHeaderNames.contains(headerEntry.getValue()))
                    .forEach(headerEntry -> limitHeaders.getHeaderEntries().add(headerEntry));

            tooManyRequestsCodeCallback.accept(context, limitHeaders);
        }


    }
}
