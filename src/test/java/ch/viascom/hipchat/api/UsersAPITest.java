package ch.viascom.hipchat.api;

import ch.viascom.hipchat.api.exception.APIException;
import ch.viascom.hipchat.api.models.PrivateMessage;
import ch.viascom.hipchat.api.models.message.MessageFormat;
import ch.viascom.hipchat.api.models.user.UserRole;
import ch.viascom.hipchat.api.request.models.CreateUser;
import ch.viascom.hipchat.api.request.models.GetAllUsers;
import ch.viascom.hipchat.api.request.models.UpdateUser;
import ch.viascom.hipchat.api.response.CreateUserResponse;
import ch.viascom.hipchat.api.response.GetAllUsersResponse;
import ch.viascom.hipchat.api.response.ViewUserResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by patrickboesch on 19.04.16.
 */
public class UsersAPITest {

    private static final Logger log = LogManager.getLogger(RoomAPITest.class);
    private static final String clientToken = "DTuhh3IS1j3jTA8YYKIife8S3XfsDymLrR1VODD6";
    private static final String integrationToken = "";

    private static String testBotUserId = "";
    private static final String privateMessageUserId = "";

    //@Test
    public void getAllUsersTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        GetAllUsersResponse getAllUsersResponse = hipChat.usersAPI().getAllUsers(new GetAllUsers(0, 100, true, true));
    }

    //@Test
    public void createUserTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);

        CreateUser createUser = new CreateUser();
        createUser.setEmail("info@viascom.ch");
        createUser.setGroup_admin(false);
        createUser.setMention_name("HipChatBot");
        createUser.setName("HipChat-Bot");
        createUser.getRoles().add(UserRole.USER);
        createUser.setTimezone("CET");
        createUser.setTitle("Viascom Bot");

        CreateUserResponse response = hipChat.usersAPI().createUser(createUser);
        testBotUserId = response.getId();
    }

    //@Test
    public void viewUserTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        ViewUserResponse viewUserResponse = hipChat.usersAPI().viewUser(testBotUserId);
    }

    //@Test
    public void deleteUserTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.usersAPI().deleteUser(testBotUserId);
    }

    //@Test
    public void updateUserTest() throws APIException {
        HipChat hipChat = new HipChat(clientToken);

        UpdateUser updateUser = new UpdateUser();
        updateUser.setEmail("info@viascom.ch");
        updateUser.setGroup_admin(false);
        updateUser.setMention_name("HipChatBot");
        updateUser.setName("HipChat-Bot");
        updateUser.getRoles().add(UserRole.USER);
        updateUser.setTimezone("CET");
        updateUser.setTitle("Viascom Test Bot");
        updateUser.setUserId(testBotUserId);

        hipChat.usersAPI().updateUser(updateUser);
    }

    //@Test
    public void sendPrivateMessage() throws APIException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.usersAPI().sendPrivateMessage(new PrivateMessage(privateMessageUserId,"Hi",true, MessageFormat.TEXT));
    }

}
