package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.javarush.quest.zazimko.questdelta.entity.User;
import ua.com.javarush.quest.zazimko.questdelta.util.UserRole;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ua.com.javarush.quest.zazimko.questdelta.util.UserRole.ADMIN;

public class UserTest {
    private static User user;
    @BeforeEach
    public void init() {
        user = new User("Ivan", "111", ADMIN);
    }
@Test
    public void getLoginTest() throws NoSuchFieldException, IllegalAccessException {
    Field login = User.class.getDeclaredField("login");
    login.setAccessible(true);
    Object o = login.get(user);
    String loginValue= (String) o;
    assertEquals("Ivan",loginValue);
    }
    @Test
    public void getPasswordTest() throws NoSuchFieldException, IllegalAccessException {
        Field password = User.class.getDeclaredField("password");
        password.setAccessible(true);
        Object o = password.get(user);
        String passwordValue= (String) o;
        assertEquals("111",passwordValue);
    }
    @Test
    public void getRoleTest(){
        UserRole role = user.getRole();
        assertEquals(UserRole.ADMIN,role);
    }

}
