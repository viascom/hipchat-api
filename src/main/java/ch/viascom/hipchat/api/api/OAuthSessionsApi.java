package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.annotation.types.Header;
import ch.viascom.groundwork.foxhttp.annotation.types.Path;

@Path("{host}")
@Header(name = "Content-Type", value = "application/json")
public interface OAuthSessionsApi {

}
