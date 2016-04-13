package ch.viascom.hipchat.api;

import ch.viascom.hipchat.api.api.RoomsAPI;
import ch.viascom.hipchat.api.models.Card;
import ch.viascom.hipchat.api.models.Room;
import ch.viascom.hipchat.api.request.GetAllMembersRequest;
import ch.viascom.hipchat.api.request.models.GetAllMembers;
import ch.viascom.hipchat.api.request.models.GetAllRooms;
import ch.viascom.hipchat.api.models.Notification;
import ch.viascom.hipchat.api.models.Topic;
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
public class HipChatTest {

    private static final Logger log = LogManager.getLogger(HipChatTest.class);

    //@Test
    public void sendMessage() {
        HipChat hipChat = new HipChat();
        //RoomsAPI roomsAPI = hipChat.setAccessToken("67oFsPudKs4Vc11EwHUC3tVJroc7PFkzVC0ppH1d").roomsAPI();

        RoomsAPI roomsAPI = hipChat.setAccessToken("DTuhh3IS1j3jTA8YYKIife8S3XfsDymLrR1VODD6").roomsAPI();

        Notification notification = new Notification();
        notification.setRoomId("2165914");
        notification.setMessage("Hi from (puzzle) Viascom-HipChat-API v2");
        notification.setColor(MessageColor.GRAY);
        notification.setNotify(true);

        roomsAPI.sendRoomNotification(notification);
    }

    //@Test
    public void sendMessage2() {

        HipChat hipChat = new HipChat("DTuhh3IS1j3jTA8YYKIife8S3XfsDymLrR1VODD6");
        hipChat.roomsAPI().sendRoomNotification(new Notification("Hello World", MessageColor.RED, true));
    }

    //@Test
    public void setTopic() {

        HipChat hipChat = new HipChat("DTuhh3IS1j3jTA8YYKIife8S3XfsDymLrR1VODD6");
        hipChat.roomsAPI().setTopic(new Topic("Mivas", "Test-Topic"));
    }

    //@Test
    public void testThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future = executorService.submit(() -> {
            System.out.println("Asynchronous Callable");
            return "Callable Result";
        });

        try {
            System.out.println("future.get() = " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    //@Test
    public void getAllRooms() throws ExecutionException, InterruptedException, TimeoutException {
        HipChat hipChat = new HipChat("DTuhh3IS1j3jTA8YYKIife8S3XfsDymLrR1VODD6");
        GetAllRoomsResponse response = hipChat.roomsAPI().getAllRooms(new GetAllRooms());
        log.debug(response);

    }

    //@Test
    public void createRoom(){
        HipChat hipChat = new HipChat("DTuhh3IS1j3jTA8YYKIife8S3XfsDymLrR1VODD6");

        Room room = new Room();

        room.setName("Auto-Room");

        CreateRoomResponse response = hipChat.roomsAPI().createRoom(room);

        hipChat.roomsAPI().deleteRoom(room.getName());
    }

    //@Test
    public void getAllMembers(){
        HipChat hipChat = new HipChat("DTuhh3IS1j3jTA8YYKIife8S3XfsDymLrR1VODD6");
        GetAllMembersResponse getAllMembersResponse = hipChat.roomsAPI().getAllMembers(new GetAllMembers("Mivas",0,100));
        log.debug(getAllMembersResponse);
    }


    //@Test
    public void sendMessageCard() {
        HipChat hipChat = new HipChat();
        RoomsAPI roomsAPI = hipChat.setAccessToken("67oFsPudKs4Vc11EwHUC3tVJroc7PFkzVC0ppH1d").roomsAPI();

        Notification notification = new Notification();
        notification.setRoomId("2165914");
        notification.setMessage("Hi from (puzzle) Viascom-HipChat-API v2");
        notification.setColor(MessageColor.RED);
        notification.setNotify(true);

        Card card = new Card();
        card.setTitle("First Plugin Card");

        CardIcon icon = new CardIcon();
        icon.setUrl("https://dujrsrsgsd3nh.cloudfront.net/img/emoticons/22438/fire-1366382911.png");
        card.setIcon(icon);
        card.setStyle(CardStyle.APPLICATION);
        card.setUrl("http://viascom.ch");
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

        cardActivity.setHtml("Ich habe einen Fehler gefunden !!");
        cardActivity.setIcon(icon);

        card.setActivity(cardActivity);

        notification.setCard(card);

        roomsAPI.sendRoomNotification(notification);
    }
}
