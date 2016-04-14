package ch.viascom.hipchat.api;

import ch.viascom.hipchat.api.api.RoomsAPI;
import ch.viascom.hipchat.api.models.*;
import ch.viascom.hipchat.api.request.models.GetAllMembers;
import ch.viascom.hipchat.api.request.models.GetAllRooms;
import ch.viascom.hipchat.api.models.card.*;
import ch.viascom.hipchat.api.models.message.MessageColor;
import ch.viascom.hipchat.api.response.CreateRoomResponse;
import ch.viascom.hipchat.api.response.GetAllMembersResponse;
import ch.viascom.hipchat.api.response.GetAllRoomsResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by patrickboesch on 11.04.16.
 */
public class RoomAPITest {

    private static final Logger log = LogManager.getLogger(RoomAPITest.class);
    private static final String clientToken = "";
    private static final String integrationToken = "";

    //@Test
    public void sendRoomNotificationTest() {
        HipChat hipChat = new HipChat(integrationToken);
        hipChat.roomsAPI().sendRoomNotification(new Notification("Test-Room", "Hello World", MessageColor.RED, true));
    }

    //@Test
    public void sendRoomMessageTest() {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.roomsAPI().sendRoomMessage(new Message("Test-Room", "Hello World"));
    }

    //@Test
    public void replyToMessageTest() {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.roomsAPI().replyToMessage(new ReplyMessage("Test-Room", "Reply", "")); // Fill out last parameter with parentId
    }

    //@Test
    public void setTopicTest() {
        HipChat hipChat = new HipChat(integrationToken);
        hipChat.roomsAPI().setTopic(new Topic("Test-Room", "New fancy topic for our test room"));
    }

    //@Test
    public void sendRoomNotificationCardTest() {
        HipChat hipChat = new HipChat(integrationToken);
        RoomsAPI roomsAPI = hipChat.roomsAPI();

        Notification notification = new Notification();
        notification.setRoomId("Test-Room");
        notification.setMessage("Hi from (puzzle) HipChat-API v2");
        notification.setColor(MessageColor.RED);
        notification.setNotify(true);

        Card card = new Card();
        card.setTitle("API Card");

        CardIcon icon = new CardIcon();
        icon.setUrl("https://dujrsrsgsd3nh.cloudfront.net/img/emoticons/22438/fire-1366382911.png");
        card.setIcon(icon);
        card.setStyle(CardStyle.APPLICATION);
        card.setUrl("http://github.com");
        card.setId("3985698273957");
        card.setFormat(CardFormat.COMPACT);

        CardAttribute cardAttribute = new CardAttribute();

        cardAttribute.setLabel("Version");

        CardAttributeValue cardAttributeValue = new CardAttributeValue();

        cardAttributeValue.setLabel("1.0");
        CardIcon icon2 = new CardIcon();
        icon2.setUrl("https://dujrsrsgsd3nh.cloudfront.net/img/emoticons/22438/puzzle-1366382992.png");
        cardAttributeValue.setIcon(icon2);

        cardAttribute.setValue(cardAttributeValue);

        card.getAttributes().add(cardAttribute);

        CardActivity cardActivity = new CardActivity();

        cardActivity.setHtml("API test Card from hipchat-api");
        cardActivity.setIcon(icon);

        card.setActivity(cardActivity);

        notification.setCard(card);

        roomsAPI.sendRoomNotification(notification);
    }
}
