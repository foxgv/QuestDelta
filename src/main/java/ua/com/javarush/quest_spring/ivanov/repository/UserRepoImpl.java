package ua.com.javarush.quest_spring.ivanov.repository;

import ua.com.javarush.quest_spring.ivanov.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepoImpl implements UserRepo {

    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        int id = users.size() + 1;
        user.setId(id);
        users.put(id, user);
    }

    @Override
    public Map<Integer, User> getUsers() {
        return users;
    }

    @Override
    public void updateUser(User user) {
        users.replace(user.getId(), user);

    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public User getUserByUserName(String username) {
        Collection<User> usersList = users.values();
        User user = null;
        for (User item : usersList) {
            if (item.getUsername().equals(username)) {
                user = item;
            }
        }
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        users.remove(id);
    }

    @Override
    public boolean isUserPresent(String login) {
        Collection<User> usersList = users.values();
        for (User item : usersList) {
            if (item.getUsername().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
