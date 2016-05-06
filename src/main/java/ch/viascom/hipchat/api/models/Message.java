package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.message.*;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Created by Patrick Bösch on 11.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    /**
     * The user that sent the message.
     * May be null.
     */
    private MessageFrom from;

    /**
     * The date the message was sent in ISO-8601 format.
     */
    private String date;

    /**
     * The message sent
     */
    private String message;

    /**
     * A list of mentioned users in this message.
     * An array of the following objects.
     */
    private ArrayList<MessageMention> mentions;

    /**
     * The type of message being returned
     * Valid values: message, guest_access, topic, notification.
     */
    private MessageType type;

    /**
     * The internal unique id of the message
     */
    private String id;

    /**
     * Background color for message.
     * Valid values: yellow, green, red, purple, gray.
     * Defaults to 'yellow'.
     */
    private MessageColor color;

    /**
     * Determines how the message is treated by our server and rendered inside HipChat applications.
     * Valid values: html, text.
     * Defaults to 'html'.
     */
    @SerializedName("message_format")
    private MessageFormat messageFormat = MessageFormat.HTML;

    /**
     * The file URL attached to the message, if specified.
     */
    private MessageFile file;

    /**
     * A list of links extracted from the message and some extended data (currently only extracts the last link from the message)
     * An array of the following objects.
     */
    @SerializedName("message_links")
    private ArrayList<MessageLink> messageLinks;

    /**
     * !NOT IN API REFERENCE!
     */
    @SerializedName("notification_sender")
    private NotificationSender notificationSender;
}
