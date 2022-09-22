package ua.com.javarush.quest_spring.ivanov.services;

import ua.com.javarush.quest_spring.ivanov.entities.User;

import java.util.Map;

public interface UserService {

    void addUser(User user);

    Map<Integer,User> getUsers();

    void updateUserById(User user);

    User getUserById(int id);

    void deleteUserById(int id);

    boolean isUserPresent(String login);

    User getUserByUserName(String username);
}
