package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Game;
import ru.javarush.quest.bogdanov.questdelta.entities.Role;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public enum UserService {
    USER_SERVICE;

    private final UserRepository userRepository = new UserRepository();

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(long id) {
        return Optional.ofNullable(userRepository.getByID(id));
    }

    public boolean create(String login, String password, Role role) {
        if (find(login, password).isPresent()) {
            return false;
        } else {
            User user = new User(login, password, role);
            userRepository.create(user);
            return true;
        }
    }

    public boolean update(long id, String login, String password, Role role) {
        if (getUser(id).isPresent()) {
            User user = getUser(id).get();
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(role);
            userRepository.update(user);
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        if (getUser(id).isPresent()) {
            User user = getUser(id).get();
            userRepository.delete(user.id);
            return true;
        }
        return false;
    }

    public Optional<User> find(String login, String password) {
        User user = new User(login, password);
        return userRepository.find(user);
    }

    public void addGame(Game game, long id) {
        userRepository.addGame(game, id);
    }
}
