package ch.viascom.hipchat.api.api;

import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 14.04.16.
 */
public abstract class GenericAPI {
    protected final String baseUrl;
    protected final String accessToken;
    protected final HttpClient httpClient;
    protected final ExecutorService executorService;

    public GenericAPI(String baseUrl, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        this.baseUrl = baseUrl;
        this.accessToken = accessToken;
        this.httpClient = httpClient;
        this.executorService = executorService;
    }
}
