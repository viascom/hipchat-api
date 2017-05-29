package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.FoxHttpResponse;
import ch.viascom.groundwork.foxhttp.annotation.types.*;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.Message;
import ch.viascom.hipchat.api.models.Notification;
import ch.viascom.hipchat.api.models.Room;
import ch.viascom.hipchat.api.models.Webhook;
import ch.viascom.hipchat.api.models.room.RoomStatistics;
import ch.viascom.hipchat.api.request.models.*;
import ch.viascom.hipchat.api.response.*;

@Path("{host}")
@Header(name = "Content-Type", value = "application/json")
public interface RoomsApi {

    @GET("/room/{room}")
    Room getRoom(@Path("room") String roomIdOrName) throws FoxHttpException;

    @POST("/room")
    FoxHttpResponse createRoom(@Body Room room) throws FoxHttpException;

    @PUT("/room/{room}")
    @SkipResponseBody(true)
    FoxHttpResponse updateRoom(@Path("room") String roomIdOrName, @Body() Room room) throws FoxHttpException;

    @DELETE("/room/{room}")
    @SkipResponseBody(true)
    Room deleteRoom(@Path("room") String roomIdOrName) throws FoxHttpException;

    @GET("/room")
    Room getAllRoom(@Query("start-index") String startIndex,
                    @Query("max-results") String maxResults,
                    @Query("include-private") String includePrivate,
                    @Query("include-archived") String includeArchived) throws FoxHttpException;

    @POST("/room/{room}/notification")
    FoxHttpResponse sendRoomNotification(@Path("room") String roomIdOrName,
                                         @Body Notification notification) throws FoxHttpException;

    @POST("/room/{room}/message")
    FoxHttpResponse sendRoomMessage(@Path("room") String roomIdOrName,
                                    @Body MessageRequestBody message) throws FoxHttpException;

    @POST("/room/{room}/reply")
    @SkipResponseBody(true)
    FoxHttpResponse replyToMessage(@Path("room") String roomIdOrName,
                                   @Body ReplyMessage message) throws FoxHttpException;

    @PUT("/room/{room}/topic")
    @SkipResponseBody(true)
    FoxHttpResponse setTopic(@Path("room") String roomIdOrName,
                             @Body SetTopic topic) throws FoxHttpException;

    @GET("/room/{room}/extension/webhook/{key}")
    Webhook getRoomWebhook(@Path("room") String roomIdOrName, @Path("key") String key) throws FoxHttpException;

    @PUT("/room/{room}/extension/webhook/{key}")
    FoxHttpResponse createRoomWebhook(@Path("room") String roomIdOrName, @Path("key") String key,
                                      @Body CreateRoomWebhook createRoomWebhook) throws FoxHttpException;

    @DELETE("/room/{room}/extension/webhook/{key}")
    @SkipResponseBody(true)
    Webhook deleteRoomWebhook(@Path("room") String roomIdOrName, @Path("key") String key) throws FoxHttpException;

    @GET("/room/{room}/history/{message_id}")
    Message getRoomMessage(@Path("room") String roomIdOrName, @Path("message_id") String messageId,
                           @Query("timezone") String timezone, @Query("include_deleted") String includeDeleted)
            throws FoxHttpException;

    @GET("/room/{room}/history")
    ViewRoomHistoryResponse viewRoomHistory(@Path("room") String roomIdOrName,
                                            @QueryObject() ViewRoomHistory viewRoomHistory) throws FoxHttpException;

    @GET("/room/{room}/history/latest")
    ViewRecentRoomHistoryResponse viewRecentRoomHistory(@Path("room") String roomIdOrName,
                                                        @QueryObject() ViewRecentRoomHistory viewRecentRoomHistory)
            throws FoxHttpException;

    @POST("room/{room}/invite/{user}")
    @SkipResponseBody(true)
    FoxHttpResponse inviteUser(@Path("room") String roomIdOrName, @Path("user") String userIdOrEmail,
                               @Body String reason) throws FoxHttpException;

    @GET("/room/{room}/member")
    GetAllMembersResponse getAllMembers(@Path("room") String roomIdOrName,
                                        @Query("start-index") String startIndex,
                                        @Query("max-results") String maxResults) throws FoxHttpException;

    @PUT("/room/{room}/member/{user}")
//    @SkipResponseBody(true)
    FoxHttpResponse addMember(@Path("room") String roomIdOrName, @Path("user") String userIdOrEmail,
                              @Body AddMember addMember) throws FoxHttpException;

    @DELETE("/room/{room}/member/{user}")
    @SkipResponseBody(true)
    FoxHttpResponse removeMember(@Path("room") String roomIdOrName, @Path("user") String userIdOrEmail) throws FoxHttpException;

    @GET("/room/{room}/participant")
    GetAllParticipantsResponse getAllParticipants(@Path("room") String roomIdOrName,
                                                  @Query("start-index") String startIndex,
                                                  @Query("max-results") String maxResults,
                                                  @Query("include-offline") String includeOffline) throws FoxHttpException;

    @GET("/room/{room}/statistics")
    RoomStatistics getRoomStatistics(@Path("room") String roomIdOrName) throws FoxHttpException;

    @GET("/room/{room}/webhook")
    GetAllWebhooksResponse getAllWebhooks(@Path("room") String roomIdOrName,
                                          @Query("start-index") String startIndex,
                                          @Query("max-results") String maxResults) throws FoxHttpException;
}
