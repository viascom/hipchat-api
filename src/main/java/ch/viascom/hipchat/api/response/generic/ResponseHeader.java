package ch.viascom.hipchat.api.response.generic;

import lombok.Data;
import org.apache.http.Header;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class ResponseHeader {
    private int statusCode;
    private String requestPath;
    private Header[] responseHeaders;
}
