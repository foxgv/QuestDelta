package ua.com.javarush.quest.ryabov.questdelta.service;

import ua.com.javarush.quest.ryabov.questdelta.entity.User;
import ua.com.javarush.quest.ryabov.questdelta.repository.Repository;
import ua.com.javarush.quest.ryabov.questdelta.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

public enum UserService {

    INSTANCE;

    private final Repository<User> userRepository = UserRepository.get();

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> get(long id) {
        return userRepository.get(id);
    }
    public Collection<User> find(User patternUser) {
        return userRepository.find(patternUser);
    }

    public Optional<User> find(String login, String password){
        User user = User.with()
                .login(login)
                .password(password)
                .get();
        Collection<User> users = find(user);
        return users.stream().findFirst();
    }
}
