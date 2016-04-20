package ch.viascom.hipchat.api.response;

import ch.viascom.hipchat.api.response.generic.Response;
import ch.viascom.hipchat.api.response.generic.ResponseHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpEntity;

/**
 * Created by patrickboesch on 20.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse implements Response {
    private ResponseHeader responseHeader;
    private HttpEntity entity;

    public GenericResponse(HttpEntity entity) {
        this.entity = entity;
    }
}
