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

    Quest quest;
    String name;
    InetAddress USER_ADDRESS_TEST;

    @BeforeEach
    public void init()throws UnknownHostException{
        name = "Edward";
        USER_ADDRESS_TEST = InetAddress.getLocalHost();
        quest = new Quest(name, USER_ADDRESS_TEST);
    }


    @org.junit.jupiter.api.Test
    void getUserAddress(){
        assertEquals(USER_ADDRESS_TEST, quest.getUserAddress());
    }

    @org.junit.jupiter.api.Test
    void getUserName() {
        assertEquals(name, quest.getUserName());
    }

    @org.junit.jupiter.api.Test
    void getLEVEL_TEST() {
        int test_level = 1;
        assertEquals(test_level, quest.getLEVEL());
    }

    @org.junit.jupiter.api.Test
    void setLEVEL() {
        quest.setLEVEL(2);
        assertEquals(2, quest.getLEVEL());
    }

    @org.junit.jupiter.api.Test
    void checkLose() {
        assertTrue(quest.checkLose(3));
    }

    @org.junit.jupiter.api.Test
    void checkWin() {
        assertTrue(quest.checkWin(0));
    }

    @org.junit.jupiter.api.Test
    void getCurrentLevelText() {
        List<String> text_test = new ArrayList<>();
        text_test.add("You've lost your memory. Accept the UFO challenge?");
        text_test.add("Take the challenge");
        text_test.add("Reject a call");
        assertEquals(text_test, quest.getCurrentLevelText(1));
    }
}