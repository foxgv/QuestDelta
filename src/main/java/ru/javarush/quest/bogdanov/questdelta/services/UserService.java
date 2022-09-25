package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Role;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.repositories.Repository;
import ru.javarush.quest.bogdanov.questdelta.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public enum UserService {
    USER_SERVICE;

    private final Repository<User> userRepository = new UserRepository();

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(long id) {
        return Optional.ofNullable(userRepository.getByID(id));
    }

    public void create(String login, String password, Role role) {
        User user = new User(login, password, role);
        userRepository.create(user);
    }

    public void update(long id, String login, String password, Role role) {
        User user = getUser(id).get();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        userRepository.update(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public Optional<User> find(String login, String password) {
        User user = new User(login, password);
        return userRepository.find(user);
    }
}
