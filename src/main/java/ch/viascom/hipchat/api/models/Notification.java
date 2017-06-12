package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.message.MessageColor;
import ch.viascom.hipchat.api.models.message.MessageFormat;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification implements Serializable {
    /**
     * A label to be shown in addition to the sender's name
     * Valid length range: 0 - 64.
     */
    private String from;

    /**
     * Determines how the message is treated by our server and rendered inside HipChat applications
     * - html - Message is rendered as HTML and receives no special treatment. Must be valid HTML and entities must be escaped &#40;e.g.: '&amp;amp;' instead of '&amp;'&#41;. May contain basic tags: a, b, i, strong, em, br, img, pre, code, lists, tables.
     * - text - Message is treated just like a message sent by a user. Can include @mentions, emoticons, pastes, and auto-detected URLs (Twitter, YouTube, images, etc).
     * Valid values: html, text.
     * Defaults to 'html'.
     */
    @SerializedName("message_format")
    private MessageFormat messageFormat;

    /**
     * Background color for message.
     * Valid values: yellow, green, red, purple, gray, random.
     * Defaults to 'yellow'.
     */
    private MessageColor color;

    /**
     * The message id to to attach this notification to, for example if this notification is in response to a particular message.
     * For supported clients, this will display the notification in the context of the referenced message specified by attach_to parameter.
     * If this is not possible to attach the notification, it will be rendered as an unattached notification.
     * The message must be in the same room as that the notification is sent to.
     * Valid length range: 0 - 36.
     */
    @SerializedName("attach_to")
    private String attachTo;

    /**
     * Whether this message should trigger a user notification (change the tab color, play a sound, notify mobile phones, etc). Each recipient's notification preferences are taken into account.
     * Defaults to false.
     */
    private boolean notify;

    /**
     * The message body
     * Valid length range: 1 - 10000.
     */
    private String message;

    /**
     * An optional card object
     * May be null.
     */
    private Card card;
}
