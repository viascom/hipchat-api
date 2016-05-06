package ch.viascom.hipchat.api.response.generic;

import lombok.Data;
import org.apache.http.Header;

import java.util.HashMap;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class ResponseHeader {
    private int statusCode;
    private String requestPath;
    private HashMap<String, String> responseHeaders = new HashMap<>();

    public void setResponseHeaders(Header[] responseHeaders) {
        for (Header header : responseHeaders) {
            String name = header.getName();
            String value = header.getValue();
            this.responseHeaders.put(name, value);
        }
    }
}
