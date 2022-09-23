package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.Role;
import ua.com.javarush.quest.kossatyy.questdelta.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class UserRepository implements Repository<User>{

    private static final AtomicLong id = new AtomicLong(System.currentTimeMillis());
    private static UserRepository userRepository;

    private final Map<Long, User> users = new HashMap<>();

    private UserRepository() {
        users.put(1L, User.builder()
                .id(1L)
                .login("admin")
                .password("123")
                .role(Role.ADMIN)
                .build());
        users.put(2L, User.builder()
                .id(2L)
                .login("user")
                .password("1234")
                .role(Role.USER)
                .build());
        users.put(3L, User.builder()
                .id(3L)
                .login("editor")
                .password("12345")
                .role(Role.EDITOR)
                .build());
        users.put(4L, User.builder()
                .id(4L)
                .login("guest")
                .password("333")
                .role(Role.GUEST)
                .build());
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    @Override
    public Collection<User> getAll() {
        return users.values()
                .stream()
                .toList();
    }

    @Override
    public User getById(long id) {
        return users.get(id);
    }

    @Override
    public Stream<User> find(User user) {
        return users.values().stream()
                .filter(userInDB -> userInDB.getLogin().equals(user.getLogin()));
    }

    @Override
    public void create(User entity) {
        entity.setId(id.incrementAndGet());
        update(entity);
    }

    @Override
    public void update(User entity) {
        users.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(long id) {
        users.remove(id);
    }
}
