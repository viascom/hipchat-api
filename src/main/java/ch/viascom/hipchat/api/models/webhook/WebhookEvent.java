package ch.viascom.hipchat.api.models.webhook;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patrickboesch on 18.04.16.
 */
public enum WebhookEvent {
    @SerializedName("room_archived")
    ROOM_ARCHIVED,
    @SerializedName("room_created")
    ROOM_CREATED,
    @SerializedName("room_deleted")
    ROOM_DELETED,
    @SerializedName("room_enter")
    ROOM_ENTER,
    @SerializedName("room_exit")
    ROOM_EXIT,
    @SerializedName("room_file_upload")
    ROOM_FILE_UPLOAD,
    @SerializedName("room_message")
    ROOM_MESSAGE,
    @SerializedName("room_notification")
    ROOM_NOTIFICATION,
    @SerializedName("room_topic_change")
    ROOM_TOPIC_CHANGE,
    @SerializedName("room_unarchived")
    ROOM_UNARCHIVED
}
