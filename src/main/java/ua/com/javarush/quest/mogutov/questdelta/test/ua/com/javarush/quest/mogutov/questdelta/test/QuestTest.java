package ua.com.javarush.quest.mogutov.questdelta.test;
import org.junit.jupiter.api.*;
import ua.com.javarush.quest.mogutov.questdelta.data.Quest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

class QuestTest {
    static Quest quest;
    static String name;
    static InetAddress USER_ADDRESS_TEST;

    @BeforeAll
    static void init()throws UnknownHostException{
        name = "Edward";
        USER_ADDRESS_TEST = InetAddress.getLocalHost();
        quest = new Quest(name, USER_ADDRESS_TEST);
    }

    @Test
    void getUserAddress(){
        assertEquals(USER_ADDRESS_TEST, quest.getUserAddress());
    }

    @Test
    void getUserName() {
        assertEquals(name, quest.getUserName());
    }

    @Test
    void getLEVEL_TEST() {
        int test_level = 1;
        assertEquals(test_level, quest.getLEVEL());
    }

    @Test
    void setLEVEL() {
        quest.setLEVEL(2);
        assertEquals(2, quest.getLEVEL());
    }

    @Test
    void checkLose() {
        assertTrue(quest.checkLose(3));
    }

    @Test
    void checkWin() {
        assertTrue(quest.checkWin(0));
    }

    @Test
    void getCurrentLevelText() {
        List<String> text_test = new ArrayList<>();
        text_test.add("You've lost your memory. Accept the UFO challenge?");
        text_test.add("Take the challenge");
        text_test.add("Reject a call");
        assertEquals(text_test, quest.getCurrentLevelText(1));
    }
}