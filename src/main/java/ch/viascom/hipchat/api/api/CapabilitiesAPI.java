package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.annotation.types.GET;
import ch.viascom.groundwork.foxhttp.annotation.types.Path;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.Capabilities;

@Path("{host}")
public interface CapabilitiesAPI {

    @GET("/capabilities")
    Capabilities getCapabilities() throws FoxHttpException;

}
