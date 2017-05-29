package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.FoxHttpResponse;
import ch.viascom.groundwork.foxhttp.annotation.types.*;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.Group;

@Path("{host}")
public interface GroupsApi {

    @GET("/emoticon/{group_id}")
    Group viewGroup(@Path("id") String groupId) throws FoxHttpException;

    @GET("/emoticon/{group_id}/avatar")
    FoxHttpResponse getGroupAvatar(@Path("id") String groupId) throws FoxHttpException;

    @PUT("/emoticon/{group_id}/avatar")
    FoxHttpResponse updateGroupAvatar(@Path("id") String groupId, @Body String avatar) throws FoxHttpException;

    @DELETE("/emoticon/{group_id}/avatar")
    FoxHttpResponse deleteGroupAvatar(@Path("id") String groupId) throws FoxHttpException;

    @GET("/emoticon/{group_id}/statistics")
    FoxHttpResponse groupStatistics(@Path("id") String groupId) throws FoxHttpException;

}
