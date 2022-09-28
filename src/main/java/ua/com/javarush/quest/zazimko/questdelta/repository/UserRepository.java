package ua.com.javarush.quest.zazimko.questdelta.repository;

import ua.com.javarush.quest.zazimko.questdelta.entity.User;
import ua.com.javarush.quest.zazimko.questdelta.util.UserRole;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static Map<Long,User> userList;

    public UserRepository() {
       userList= new HashMap();
       userList.put(1L,new User(1,"Ivan","123", UserRole.ADMIN));
       userList.put(2L,new User(2,"Fedor","456", UserRole.USER));
       userList.put(3L,new User(3,"Ivan","789", UserRole.USER));
       userList.put(4L,new User(4,"Ivan","147", UserRole.USER));
    }

    public  Map<Long, User> getUsers() {
        return userList;
    }
    public  User getUser(long id) {
        User user = userList.get(id);
        return user;
    }
}