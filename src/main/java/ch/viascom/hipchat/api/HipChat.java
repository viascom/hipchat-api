package ch.viascom.hipchat.api;


import ch.viascom.groundwork.foxhttp.FoxHttpClient;
import ch.viascom.groundwork.foxhttp.annotation.processor.FoxHttpAnnotationParser;
import ch.viascom.groundwork.foxhttp.authorization.BearerTokenAuthorization;
import ch.viascom.groundwork.foxhttp.authorization.FoxHttpAuthorizationScope;
import ch.viascom.groundwork.foxhttp.builder.FoxHttpClientBuilder;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.groundwork.foxhttp.interceptor.FoxHttpInterceptor;
import ch.viascom.groundwork.foxhttp.interceptor.FoxHttpInterceptorType;
import ch.viascom.groundwork.foxhttp.interceptor.response.context.FoxHttpResponseInterceptorContext;
import ch.viascom.groundwork.foxhttp.log.DefaultFoxHttpLogger;
import ch.viascom.groundwork.foxhttp.parser.GsonParser;
import ch.viascom.hipchat.api.api.*;
import ch.viascom.hipchat.api.exception.HipChatAPIException;
import ch.viascom.hipchat.api.interceptors.BadRequestCodeInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by patrick.boesch@viascom.ch on 11.04.16.
 */

public class HipChat {

    private static final Logger log = LogManager.getLogger(HipChat.class);
    private String baseUrl = "https://api.hipchat.com/v2";
    private String accessToken;
    private FoxHttpClient client = new FoxHttpClientBuilder(new GsonParser())
            .setFoxHttpLogger(new DefaultFoxHttpLogger(true)).build();

    private CapabilitiesAPI capabilitiesAPI;

    public HipChat(String accessToken) throws FoxHttpException {
        setAccessToken(accessToken);
        setBaseUrl(baseUrl);

        //Add default code interceptors

        //client.register(FoxHttpInterceptorType.RESPONSE,new BadRequestCodeInterceptor(this::defaultBadRequestCodeMethod));

    }


    public HipChat(String accessToken, String baseUrl) {
        setAccessToken(accessToken);
        setBaseUrl(baseUrl);
    }

    public HipChat setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        client.getFoxHttpPlaceholderStrategy().addPlaceholder("host", baseUrl);
        return this;
    }

    public HipChat setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        client.getFoxHttpAuthorizationStrategy().addAuthorization(FoxHttpAuthorizationScope.ANY, new BearerTokenAuthorization(accessToken));
        return this;
    }

    public HipChat replaceResponseInterceptor(FoxHttpInterceptor foxHttpInterceptor) {

        ArrayList<FoxHttpInterceptor> responseInterceptors = client.getFoxHttpInterceptors().get(FoxHttpInterceptorType.RESPONSE);
        responseInterceptors.stream()
                .filter(interceptor -> !interceptor.getClass().isAssignableFrom(foxHttpInterceptor.getClass()))
                .forEach(responseInterceptors::add);

        responseInterceptors.add(foxHttpInterceptor);

        client.getFoxHttpInterceptors().get(FoxHttpInterceptorType.RESPONSE).clear();
        client.getFoxHttpInterceptors().put(FoxHttpInterceptorType.RESPONSE, responseInterceptors);

        return this;
    }

    public CapabilitiesAPI capabilitiesAPI() throws FoxHttpException {
        if (capabilitiesAPI == null) {
            capabilitiesAPI = new FoxHttpAnnotationParser().parseInterface(CapabilitiesAPI.class, client);
        }
        return capabilitiesAPI;
    }

    public RoomsAPI roomsAPI() {
        return new RoomsAPI(baseUrl, accessToken, httpClient, executorService);
    }

    public EmoticonsAPI emoticonsAPI() {
        return new EmoticonsAPI(baseUrl, accessToken, httpClient, executorService);
    }

    public GroupsAPI groupsAPI() {
        return new GroupsAPI(baseUrl, accessToken, httpClient, executorService);
    }

    public UsersAPI usersAPI() {
        return new UsersAPI(baseUrl, accessToken, httpClient, executorService);
    }

    public PrefsPublicsAPI prefsPublicsAPI() {
        return new PrefsPublicsAPI(baseUrl, accessToken, httpClient, executorService);
    }


    public InvitesAPI invitesAPI() {
        return new InvitesAPI(baseUrl, accessToken, httpClient, executorService);

    }
}
