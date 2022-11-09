package ua.com.javarush.quest.gribanov.questdelta.service;

import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.gribanov.questdelta.dto.UserDTO;
import ua.com.javarush.quest.gribanov.questdelta.entity.Role;
import ua.com.javarush.quest.gribanov.questdelta.entity.User;
import ua.com.javarush.quest.gribanov.questdelta.mapper.Mapper;
import ua.com.javarush.quest.gribanov.questdelta.repository.UserRepository;

import java.util.Optional;

public class UserService {
    private static final UserService userService = new UserService();
    private final UserRepository userRepository = UserRepository.get();

    private UserService (){

    }

    public static UserService get(){
        return userService;
    }

    public Optional<UserDTO> findUser(String login, String password){
        User userTemplate = User.builder()
                .login(login)
                .password(password)
                .build();
        Optional<User> user = userRepository.find(userTemplate)
                .findFirst();

        return user.isPresent() ? Mapper.user.getDTO(user.get()) : Optional.empty();
    }

    public Optional<UserDTO> getUser(HttpSession session) {
        Object user = session.getAttribute("user");
        return user != null
                ? Optional.of((UserDTO) user)
                : Optional.empty();
    }

    public Optional<UserDTO> createUser(String name, String login, String password){
        User userTemplate = User.builder()
                .login(login)
                .build();
        if (userRepository.find(userTemplate).count() > 0){
            return Optional.empty();
        } else {
            userTemplate.setName(name);
            userTemplate.setPassword(password);
            userRepository.add(userTemplate);
            return Mapper.user.getDTO(userTemplate);
        }
    }
}
