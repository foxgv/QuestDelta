package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Role;
import ua.com.javarush.quest.kossatyy.questdelta.entity.User;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.Mapper;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.UserMapper;
import ua.com.javarush.quest.kossatyy.questdelta.repository.Repository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.UserRepository;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum UserService {
    INSTANCE;

    private final Repository<User> userRepository = UserRepository.getInstance();
    private final Mapper<UserDto, User> userMapper = new UserMapper();

    public Optional<UserDto> findByCredentials(String login, String password) {
        Optional<User> userOptional = userRepository.find(User.builder()
                        .login(login)
                        .password(password)
                        .build())
                .findFirst();

        return userOptional.map(userMapper::toDto);
    }

    public Optional<UserDto> findByLogin(String login) {
        Optional<User> userOptional = userRepository.find(User.builder()
                        .login(login)
                        .build())
                .findFirst();

        return userOptional.map(userMapper::toDto);
    }

    public boolean validateLogin(String login) {
        String regex = "^[A-Za-z\\d]{1,20}$";
        return check(regex, login);
    }

    public boolean validatePassword(String password) {
        String regex = "^[A-Za-z\\d]{1,8}$";
        return check(regex, password);
    }

    public void createUser(String login, String password, Role role) {
        userRepository.create(User.builder()
                .login(login)
                .password(password)
                .role(role)
                .build());
    }

    public void createUser(String login, String password) {
        userRepository.create(User.builder()
                .login(login)
                .password(password)
                .role(Role.USER)
                .build());
    }

    private boolean check(String regex, String input) {
        if (input == null) {
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
