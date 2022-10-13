package ua.com.javarush.quest_spring.ivanov.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import ua.com.javarush.quest_spring.ivanov.entities.Game;
import ua.com.javarush.quest_spring.ivanov.entities.User;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class GameStatsHelperTest {

    @Autowired
    private GameStatsHelper gameStatsHelper;
    private MockHttpServletRequest request;
    private User user;

    @BeforeEach
    void setup() {
        request = new MockHttpServletRequest();
        user = new User(1, new Game(1, 2, 3, 0), "username", "pass", "email");
        request.getSession().setAttribute("user", user);
    }

    @Test
    void addGameStat_Action_GameCounter() {
        String action = "gameCounter";
        int expectedResult = user.getGame().getGameCounter() + 1;
        gameStatsHelper.addGameStat(request, action);
        user = (User) request.getSession().getAttribute("user");
        int result = user.getGame().getGameCounter();
        assertEquals(expectedResult, result);
    }

    @Test
    void addGameStat_Action_Failed() {
        String action = "failed";
        int expectedResult = user.getGame().getGameFailed() + 1;
        gameStatsHelper.addGameStat(request, action);
        user = (User) request.getSession().getAttribute("user");
        int result = user.getGame().getGameFailed();
        assertEquals(expectedResult, result);
    }

    @Test
    void addGameStat_Action_GameCompleted() {
        String action = "gameCompleted";
        int expectedResult = user.getGame().getGameCompleted() + 1;
        gameStatsHelper.addGameStat(request, action);
        user = (User) request.getSession().getAttribute("user");
        int result = user.getGame().getGameCompleted();
        assertEquals(expectedResult, result);
    }


    @Test
    void setQuantityOfCorrectAnswers_Action_Add() {
        String action = "add";
        int expectedResult = user.getGame().getQuantityQuizCorrectAnswers() + 1;
        gameStatsHelper.setQuantityOfCorrectAnswers(request, action);
        user = (User) request.getSession().getAttribute("user");
        int result = user.getGame().getQuantityQuizCorrectAnswers();
        assertEquals(expectedResult, result);
    }

    @Test
    void setQuantityOfCorrectAnswers_Action_Any() {
        String action = "NotAdd";
        gameStatsHelper.setQuantityOfCorrectAnswers(request, action);
        user = (User) request.getSession().getAttribute("user");
        int result = user.getGame().getQuantityQuizCorrectAnswers();
        assertEquals(0, result);
    }
}

























