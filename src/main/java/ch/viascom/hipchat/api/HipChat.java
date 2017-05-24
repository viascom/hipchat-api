package ch.viascom.hipchat.api;


import ch.viascom.groundwork.foxhttp.FoxHttpClient;
import ch.viascom.groundwork.foxhttp.annotation.processor.FoxHttpAnnotationParser;
import ch.viascom.groundwork.foxhttp.authorization.BearerTokenAuthorization;
import ch.viascom.groundwork.foxhttp.authorization.FoxHttpAuthorizationScope;
import ch.viascom.groundwork.foxhttp.builder.FoxHttpClientBuilder;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.groundwork.foxhttp.interceptor.FoxHttpInterceptor;
import ch.viascom.groundwork.foxhttp.interceptor.FoxHttpInterceptorType;
import ch.viascom.groundwork.foxhttp.log.SystemOutFoxHttpLogger;
import ch.viascom.groundwork.foxhttp.parser.GsonParser;
import ch.viascom.hipchat.api.api.*;
import ch.viascom.hipchat.api.deserializer.MessageFromDeserializer;
import ch.viascom.hipchat.api.deserializer.MessageLinkDeserializer;
import ch.viascom.hipchat.api.models.message.MessageFrom;
import ch.viascom.hipchat.api.models.message.MessageLink;
import com.google.gson.GsonBuilder;
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
    private FoxHttpClient client;

    private CapabilitiesApi capabilitiesApi;
    private RoomsApi roomsApi;
    private EmoticonsApi emoticonsApi;
    private GroupsApi groupsApi;
    private UsersApi usersApi;
    private PrefsPublicsApi prefsPublicsApi;
    private InvitesApi invitesApi;

//    private temp() {
//        OAuth2StoreBuilder oAuth2StoreBuilder = new OAuth2StoreBuilder(GrantType.CLIENT_CREDENTIALS, "{host}/oauth/token")
//                .setAuthRequestType(RequestType.POST)
//                .addFoxHttpAuthorizationScope(FoxHttpAuthorizationScope.ANY)
//                .activateClientCredentialsUse()
//                .setUsername(solaraTestUser)
//                .setPassword(solaraTestPassword)
//                .setClientId("Ba")
//                .setClientSecret(solaraClientSecret)
//                .setRequestScopes("solara-read");
//    }

    public HipChat(String accessToken) throws FoxHttpException {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(MessageFrom.class, new MessageFromDeserializer());
        gsonBuilder.registerTypeAdapter(MessageLink.class, new MessageLinkDeserializer());

        client = new FoxHttpClientBuilder(new GsonParser(gsonBuilder.create()))
                .setFoxHttpLogger(new SystemOutFoxHttpLogger(true, "ch.viascom.hipchat")).build();

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

    public CapabilitiesApi capabilitiesAPI() throws FoxHttpException {
        if (capabilitiesApi == null) {
            capabilitiesApi = new FoxHttpAnnotationParser().parseInterface(CapabilitiesApi.class, client);
        }
        return capabilitiesApi;
    }

    public RoomsApi roomsAPI() throws FoxHttpException {
        if (roomsApi == null) {
            roomsApi = new FoxHttpAnnotationParser().parseInterface(RoomsApi.class, client);
        }
        return roomsApi;
    }

    public EmoticonsApi emoticonsAPI() throws FoxHttpException {
        if (emoticonsApi == null) {
            emoticonsApi = new FoxHttpAnnotationParser().parseInterface(EmoticonsApi.class, client);
        }
        return emoticonsApi;
    }

    public GroupsApi groupsAPI() throws FoxHttpException {
        if (groupsApi == null) {
            groupsApi = new FoxHttpAnnotationParser().parseInterface(GroupsApi.class, client);
        }
        return groupsApi;
    }

    public UsersApi usersAPI() throws FoxHttpException {
        if (usersApi == null) {
            usersApi = new FoxHttpAnnotationParser().parseInterface(UsersApi.class, client);
        }
        return usersApi;
    }

    public PrefsPublicsApi prefsPublicsAPI() throws FoxHttpException {
        if (prefsPublicsApi == null) {
            prefsPublicsApi = new FoxHttpAnnotationParser().parseInterface(PrefsPublicsApi.class, client);
        }
        return prefsPublicsApi;
    }


    public InvitesApi invitesAPI() throws FoxHttpException {
        if (invitesApi == null) {
            invitesApi = new FoxHttpAnnotationParser().parseInterface(InvitesApi.class, client);
        }
        return invitesApi;
    }
}
