package ua.com.javarush.quest.belyasnik.questdelta.repository;

import ua.com.javarush.quest.belyasnik.questdelta.entities.Question;
import ua.com.javarush.quest.belyasnik.questdelta.entities.User;
import ua.com.javarush.quest.belyasnik.questdelta.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class UserRepository {

    private static final UserRepository instance = new UserRepository();

    private List<User> users;

    public static UserRepository getInstance() {
        return instance;
    }

    private UserRepository() {
        users = new ArrayList<>();
    }

    public void add(User user) {
        users.add(user);
    }

    public int getUsersSize() {
        return users.size();
    }

    public void clearUsersList() {
        users = new ArrayList<>();
    }

}
