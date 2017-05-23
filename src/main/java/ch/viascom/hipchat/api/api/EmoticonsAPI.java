package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.annotation.types.GET;
import ch.viascom.groundwork.foxhttp.annotation.types.Path;
import ch.viascom.groundwork.foxhttp.annotation.types.Query;
import ch.viascom.hipchat.api.models.Emoticon;
import ch.viascom.hipchat.api.response.GetAllEmoticonsResponse;

@Path("{host}")
public interface EmoticonsAPI {

    @GET("/emoticon/{emoticon}")
    Emoticon getEmoticon(@Path("emoticon") String emoticonIdOrShortcut);

    @GET("/emoticon")
    GetAllEmoticonsResponse getAllEmoticons(@Query("start-index") String startIndex,
                                            @Query("max-results") String maxResults,
                                            @Query("type") String type);
}
