package ua.com.javarush.quest_spring.ivanov.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.Model;
import ua.com.javarush.quest_spring.ivanov.entities.Game;
import ua.com.javarush.quest_spring.ivanov.entities.User;
import ua.com.javarush.quest_spring.ivanov.services.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LoginActionValidatorTest {
    @Autowired
    private LoginActionValidator actionValidator;
    @Autowired
    private UserService service;
    private MockHttpServletRequest request = new MockHttpServletRequest();
    private User user;
    @MockBean
    private Model model;

    @BeforeEach
    void setup() {
        user = new User(1
                , new Game(1, 2, 3, 0)
                , "username"
                , "pass"
                , "email");
    }

    @Test
    void getSighInValidationResult_UserPresent() {
        String expectedResult = "login-page";
        service.addUser(user);
        String result = actionValidator.getSighInValidationResult(user, request, model, "filler");
        service.deleteUserById(user.getId());
        assertEquals(expectedResult, result);
    }

    @Test
    void getSighInValidationResult_UserNotPresent() {
        String expectedResult = "filler";
        service.deleteUserById(user.getId());
        String result = actionValidator.getSighInValidationResult(user, request, model, expectedResult);
        assertEquals(expectedResult, result);
    }

    @Test
    void getLogInValidationResult_UserNotPresent() {
        String expectedResult = "login-page";
        service.deleteUserById(user.getId());
        String result = actionValidator.getLogInValidationResult(user, request, model, "filler");
        assertEquals(expectedResult, result);
    }

    @Test
    void getLogInValidationResult_UserPresent_PassNotMatched() {
        String expectedResult = "login-page";
        service.addUser(user);
        User userWithDiffPass = new User(1
                , new Game(1, 2, 3, 0)
                , "username"
                , "pass1"
                , "email");
        String result = actionValidator.getLogInValidationResult(userWithDiffPass, request, model, "filler");
        service.deleteUserById(user.getId());
        assertEquals(expectedResult, result);
    }

    @Test
    void getLogInValidationResult_UserPresent_PassMatched() {
        String expectedResult = "filler";
        service.addUser(user);
        String result = actionValidator.getLogInValidationResult(user, request, model, expectedResult);
        service.deleteUserById(user.getId());
        assertEquals(expectedResult, result);
    }

}

























