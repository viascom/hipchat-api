package ch.viascom.hipchat.api.response.generic;

/**
 * Created by patrickboesch on 14.04.16.
 */
public interface Response {
    public ResponseHeader getResponseHeader();
    public void setResponseHeader(ResponseHeader responseHeader);
}
