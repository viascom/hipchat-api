package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.FoxHttpResponse;
import ch.viascom.groundwork.foxhttp.annotation.types.*;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.Group;
import ch.viascom.hipchat.api.request.models.Avatar;

@Path("{host}")
@Header(name = "Content-Type", value = "application/json")
public interface GroupsApi {

    @GET("/group/{group_id}")
    Group viewGroup(@Path("group_id") String groupId) throws FoxHttpException;

    @GET("/group/{group_id}/avatar")
    FoxHttpResponse getGroupAvatar(@Path("group_id") String groupId) throws FoxHttpException;

    @PUT("/group/{group_id}/avatar")
    FoxHttpResponse updateGroupAvatar(@Path("group_id") String groupId, @Body Avatar avatar) throws FoxHttpException;

    @DELETE("/group/{group_id}/avatar")
    FoxHttpResponse deleteGroupAvatar(@Path("group_id") String groupId) throws FoxHttpException;

    @GET("/group/{group_id}/statistics")
    FoxHttpResponse groupStatistics(@Path("group_id") String groupId) throws FoxHttpException;

}
