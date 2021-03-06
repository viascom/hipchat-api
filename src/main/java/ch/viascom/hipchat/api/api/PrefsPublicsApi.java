package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.annotation.types.GET;
import ch.viascom.groundwork.foxhttp.annotation.types.Header;
import ch.viascom.groundwork.foxhttp.annotation.types.Path;
import ch.viascom.groundwork.foxhttp.annotation.types.Query;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.response.GetAutoJoinRoomsResponse;

@Path("{host}")
@Header(name = "Content-Type", value = "application/json")
public interface PrefsPublicsApi {

    @GET("/user/{id_or_email}/preference/auto-join")
    GetAutoJoinRoomsResponse getAutoJoinRooms(@Path("id_or_email") String idOrEmail,
                                              @Query("start-index") String startIndex,
                                              @Query("max-results") String maxResults) throws FoxHttpException;
}
