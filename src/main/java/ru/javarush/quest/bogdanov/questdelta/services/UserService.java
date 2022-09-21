package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.repositories.Repository;
import ru.javarush.quest.bogdanov.questdelta.repositories.UserRepository;

import java.util.List;

public enum UserService {
    USER_SERVICE;

    private final Repository<User> userRepository = new UserRepository();

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getUser(long id) {
        return userRepository.getByID(id);
    }
}
