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
import ch.viascom.hipchat.api.api.*;
import ch.viascom.hipchat.api.deserializer.CustomGsonParser;
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

    private CapabilitiesAPI capabilitiesAPI;
    private RoomsAPI roomsAPI;
    private EmoticonsAPI emoticonsAPI;
    private GroupsAPI groupsAPI;
    private UsersAPI usersAPI;
    private PrefsPublicsAPI prefsPublicsAPI;
    private InvitesAPI invitesAPI;

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

        client = new FoxHttpClientBuilder(new CustomGsonParser(gsonBuilder))
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

    public CapabilitiesAPI capabilitiesAPI() throws FoxHttpException {
        if (capabilitiesAPI == null) {
            capabilitiesAPI = new FoxHttpAnnotationParser().parseInterface(CapabilitiesAPI.class, client);
        }
        return capabilitiesAPI;
    }

    public RoomsAPI roomsAPI() throws FoxHttpException {
        if (roomsAPI == null) {
            roomsAPI = new FoxHttpAnnotationParser().parseInterface(RoomsAPI.class, client);
        }
        return roomsAPI;
    }

    public EmoticonsAPI emoticonsAPI() throws FoxHttpException {
        if (emoticonsAPI == null) {
            emoticonsAPI = new FoxHttpAnnotationParser().parseInterface(EmoticonsAPI.class, client);
        }
        return emoticonsAPI;
    }

    public GroupsAPI groupsAPI() throws FoxHttpException {
        if (groupsAPI == null) {
            groupsAPI = new FoxHttpAnnotationParser().parseInterface(GroupsAPI.class, client);
        }
        return groupsAPI;
    }

    public UsersAPI usersAPI() throws FoxHttpException {
        if (usersAPI == null) {
            usersAPI = new FoxHttpAnnotationParser().parseInterface(UsersAPI.class, client);
        }
        return usersAPI;
    }

    public PrefsPublicsAPI prefsPublicsAPI() throws FoxHttpException {
        if (prefsPublicsAPI == null) {
            prefsPublicsAPI = new FoxHttpAnnotationParser().parseInterface(PrefsPublicsAPI.class, client);
        }
        return prefsPublicsAPI;
    }


    public InvitesAPI invitesAPI() throws FoxHttpException {
        if (invitesAPI == null) {
            invitesAPI = new FoxHttpAnnotationParser().parseInterface(InvitesAPI.class, client);
        }
        return invitesAPI;
    }
}
