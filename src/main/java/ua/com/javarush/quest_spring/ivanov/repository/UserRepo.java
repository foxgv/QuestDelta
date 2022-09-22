package ua.com.javarush.quest_spring.ivanov.repository;

import ua.com.javarush.quest_spring.ivanov.entities.User;

import java.util.Map;

public interface UserRepo {

    void addUser(User user);

    Map<Integer,User> getUsers();

    void updateUserById(User user);

    User getUserById(int id);

    User getUserByUserName(String username);

    void deleteUserById(int id);

    boolean isUserPresent(String login);
}
