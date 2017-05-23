package ch.viascom.hipchat.api;


import ch.viascom.groundwork.foxhttp.FoxHttpClient;
import ch.viascom.groundwork.foxhttp.annotation.processor.FoxHttpAnnotationParser;
import ch.viascom.groundwork.foxhttp.authorization.BearerTokenAuthorization;
import ch.viascom.groundwork.foxhttp.authorization.FoxHttpAuthorizationScope;
import ch.viascom.groundwork.foxhttp.builder.FoxHttpClientBuilder;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.groundwork.foxhttp.log.DefaultFoxHttpLogger;
import ch.viascom.groundwork.foxhttp.parser.GsonParser;
import ch.viascom.hipchat.api.api.*;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 11.04.16.
 */

public class HipChat {

    private static final int MAX_CONNECTIONS = 20;
    private static final int MAX_CONNECTIONS_PER_ROUTE = 4;

    private String baseUrl = "https://api.hipchat.com/v2";

    private String accessToken;

    private static final Logger log = LogManager.getLogger(HipChat.class);

    FoxHttpClientBuilder clientBuilder = new FoxHttpClientBuilder(new GsonParser())
            .setFoxHttpLogger(new DefaultFoxHttpLogger(true));

    public HipChat(String accessToken) {
        setAccessToken(accessToken);
        setBaseUrl(baseUrl);
    }

    public HipChat(String accessToken, String baseUrl) {
        setAccessToken(accessToken);
        setBaseUrl(baseUrl);
    }

    public HipChat setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        clientBuilder.addFoxHttpPlaceholderEntry("host", baseUrl);
        return this;
    }

    public HipChat setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        clientBuilder.addFoxHttpAuthorization(FoxHttpAuthorizationScope.ANY, new BearerTokenAuthorization(accessToken));
        return this;
    }

    public CapabilitiesAPI capabilitiesAPI() throws FoxHttpException {
        return new FoxHttpAnnotationParser().parseInterface(CapabilitiesAPI.class, clientBuilder.build());
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
