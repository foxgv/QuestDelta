package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.User;
import ua.com.javarush.quest.kossatyy.questdelta.repository.Repository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.UserRepository;

import java.util.Optional;

public enum UserService {
    INSTANCE;

    private final Repository<User> userRepository = UserRepository.getInstance();

    public Optional<User> validate(String login, String password) {
        return  userRepository.find(User.builder()
                .login(login)
                .password(password)
                .build());
    }
}
