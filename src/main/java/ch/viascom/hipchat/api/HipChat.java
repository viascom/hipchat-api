package ch.viascom.hipchat.api;


import ch.viascom.hipchat.api.api.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by patrickboesch on 11.04.16.
 */
public class HipChat {

    private static final Logger log = LogManager.getLogger(HipChat.class);

    private final CloseableHttpClient httpClient;
    private final ExecutorService executorService;
    private String baseUrl = "https://api.hipchat.com/v2";
    private String accessToken;
    private static final int MAX_CONNECTIONS = 20;
    private static final int MAX_CONNECTIONS_PER_ROUTE = 4;

    public HipChat() {
        this.httpClient = createDefaultHttpClient();
        this.executorService = createDefaultExecutorService();
    }

    public HipChat(String accessToken) {
        this();
        setAccessToken(accessToken);
    }

    public HipChat(String accessToken, String baseUrl) {
        this();
        setAccessToken(accessToken);
        setBaseUrl(baseUrl);
    }

    private static CloseableHttpClient createDefaultHttpClient() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(MAX_CONNECTIONS);
        log.debug("Max pool size: {}", MAX_CONNECTIONS);
        cm.setDefaultMaxPerRoute(MAX_CONNECTIONS_PER_ROUTE);
        log.debug("Max per route: {}", MAX_CONNECTIONS_PER_ROUTE);

        return HttpClients.custom().setConnectionManager(cm).build();
    }

    private static ExecutorService createDefaultExecutorService() {
        //setting the thread pool size equal to the max connections size
        return Executors.newFixedThreadPool(MAX_CONNECTIONS);
    }

    public HipChat setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public HipChat setBaseUrl(String url) {
        this.baseUrl = url;
        return this;
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

    public void close() {
        log.info("Shutting down...");
        try {
            httpClient.close();
        } catch (IOException e) {
            log.error("Failed to close the HttpClient.", e);
        }
        executorService.shutdown();
    }
}
