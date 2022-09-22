package ua.com.javarush.quest_spring.ivanov.services;

import ua.com.javarush.quest_spring.ivanov.entities.User;
import ua.com.javarush.quest_spring.ivanov.repository.UserRepoImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepoImpl repo;

    public UserServiceImpl(UserRepoImpl repo) {
        this.repo = repo;
    }

    @Override
    public void addUser(User user) {
        repo.addUser(user);
    }

    @Override
    public Map<Integer, User> getUsers() {
        return repo.getUsers();
    }

    @Override
    public void updateUserById(User user) {
        repo.updateUserById(user);
    }

    @Override
    public User getUserById(int id) {
        return repo.getUserById(id);
    }

    @Override
    public void deleteUserById(int id) {
        repo.deleteUserById(id);
    }

    @Override
    public boolean isUserPresent(String login) {
        return repo.isUserPresent(login);
    }

    @Override
    public User getUserByUserName(String username) {
        return repo.getUserByUserName(username);
    }
}
