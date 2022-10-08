package ua.com.javarush.quest.rbityutskih.service;

import ua.com.javarush.quest.rbityutskih.repository.UserRepository;
import ua.com.javarush.quest.rbityutskih.entity.*;
import java.util.Map;
import java.util.Optional;
public class UserService {
    private final UserRepository userRepository;
    private static UserService userService;
    private UserService() {
        UserRepository = UserRepository.get();
    }
        //this.userRepository = userRepository;


    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;

    }
}
