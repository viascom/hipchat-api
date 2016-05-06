package ch.viascom.hipchat.api.request;

import ch.viascom.hipchat.api.request.generic.DeleteRequest;
import ch.viascom.hipchat.api.request.models.RemoveMember;
import ch.viascom.hipchat.api.response.NoContentResponse;
import ch.viascom.hipchat.api.util.JsonUtil;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by Nikola Stankovic on 06.05.16.
 */
public class RemoveMemberRequest extends DeleteRequest<NoContentResponse>{
    RemoveMember removeMember;

    public RemoveMemberRequest(RemoveMember removeMember, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService){
        super(accessToken, baseUrl, httpClient, executorService);
        this.removeMember = removeMember;
    }

    @Override
    protected String getJsonBody() {
        String json = JsonUtil.getJsonBody(removeMember);
        // replace second query field
        json = json.replaceAll("\"userId\":[\"]?(\\w+(\\s+\\w+)*)[\"]?[,]?", "");
        return json;
    }

    @Override
    protected HashMap<String, String> getQueryParam() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/room/" + removeMember.getRoomId() + "/member/" + removeMember.getUserId();
    }
}
