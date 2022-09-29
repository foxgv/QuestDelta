package ua.com.javarush.quest.zazimko.questdelta.util;

import ua.com.javarush.quest.zazimko.questdelta.entity.User;
import ua.com.javarush.quest.zazimko.questdelta.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

public enum UserService {
    INSTANCE;
    private final UserRepository userRepository=UserRepository.getUserRepository();
    public Optional<User> find(String login, String password){
        User user =new User(login,password,null);
        Collection<User> users = userRepository.find(user);
        return users.stream().findFirst();
    }
}
