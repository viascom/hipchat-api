package ch.viascom.hipchat.api;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.request.models.Avatar;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class GroupsApiTest {

    private static final String clientToken = "";
    private Avatar avatar = new Avatar("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAttJREFUeNpUU0tPE1EYPdNip52W1lEeAkUoUB5NMDEgCImACSFEYiS4MtGVSxfsSEwwuiBuXfgH3LAzBp8hkRABgyIQBREtiG2VR6AUpNAZpszD746lgZucfPfe75xzv/vihu9bcdgsFjP4CK2EswQbIUn4TRgihHQ9TcflByoycLw18U6xs6iu62K2v6E6g3e6VCWxF1388DXy6VmVktgeIM7oUUGGlnLkOJTYHOL16mt3u3biqndyeBSJvT04BMHl9fkaKtu6C+fePLKq0s6yYeBX2iCppc06/LWdjZsx2RucmUFNUxPErCxsbWxgemwMOTmiN7v8UuPS1KufxH2c3vZ+0kAKgdyyusDn8XGcq6+H3WrF+mIQ8tYGfBV+/JgPgs/MCTDeocasQFLSFYiGdiDENqNwZboQmv8CSYpDO9iHWzyFREIiiioQXzx2BpJiHPa53Y0/isfj5kPBOShyDJwmw8VzUKVtiCdd4CArxOeOGyTT/UhwdmKt3F9YHFuLouCMHZk8ralxCK0YqCoTsRoJrxE/ctTAklTpognKAfrnvkdUp9OCwnwHlKQd0d1sxPc98HltcLlPYGZ+XWW8Q41ZwUNnP6yCAAvP53Xw44IwMYJKv4jSIjcc9n0k6ZqWwnF8W4jjY+ZN4bWtMU9XlBlNktDDDEwbw2inyT6hrTt/crkROysDGB0ZXE3EImvO00V5fFl7/kLxHQjeC/n6y/d9xGeqQXMLTKzJct+VlvM1q6tR/PUEcG+xefpJ8tYNyteyyMZsnuUZj/GZzjTQaaBTOc+fvp3Wde1/lOXe8Lox+m4eYJGNj+WJz3Tm1dmqr5q7sBY3T7Gob4d61cWhQW09mD5pa24FMvyt7RbRZ4q08Egti8rsCzNPl4VSa33PlOVsy23qVxFKCF5CQepXlhECLM941PcznUFnwaUO0k2wswLYAuzJpaJZJSviCNinZ+93hwzUfwIMAM4CYRv4lnqQAAAAAElFTkSuQmCC");

    @Test
    public void viewGroupTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsApi().viewGroup("");
    }

    @Test
    @Ignore // HipChat doesn't work here
    public void getGroupAvatarTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsApi().getGroupAvatar("");
    }

    @Test
    @Ignore // HipChat doesn't work here
    public void updateGroupAvatarTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsApi().updateGroupAvatar("", avatar);
    }

    @Test
    @Ignore // HipChat doesn't work here
    public void deleteGroupAvatarTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsApi().deleteGroupAvatar("");
    }

    @Test
    public void groupStatisticsTest() throws FoxHttpException {
        HipChat hipChat = new HipChat(clientToken);
        hipChat.groupsApi().groupStatistics("");
    }
}
