package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.PostRequest;
import ch.viascom.hipchat.api.request.models.SendNotification;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 11.04.16.
 */
public class SendNotificationRequest extends PostRequest<NoContentResponse> {
    private SendNotification notification;

    public SendNotificationRequest(SendNotification notification, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.notification = notification;
    }

    @Override
    protected String getJsonBody() {
        return JsonUtil.getJsonBody(notification);
    }

    @Override
    protected String getPath() {
        return "/room/" + notification.getRoomId() + "/notification";
    }
}