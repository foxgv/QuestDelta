package ua.com.javarush.quest.ryabov.questdelta.repository;

import ua.com.javarush.quest.ryabov.questdelta.entity.Role;
import ua.com.javarush.quest.ryabov.questdelta.entity.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class UserRepository implements Repository<User> {

    public static final AtomicLong id = new AtomicLong(System.currentTimeMillis());
    private final Map<Long, User> map = new HashMap<>();
    public static final UserRepository userRepository = new UserRepository();

    public static UserRepository get() {
        return userRepository;
    }

    private UserRepository() {
        map.put(1L, User.with()
                .id(1L).login("Ivan").password("456")
                .image("avatar-1").role(Role.ADMIN).get());
        map.put(2L, User.with()
                .id(2L).login("Andrew").password("789")
                .image("avatar-2").role(Role.GUEST).get());
        map.put(3L, User.with()
                .id(3L).login("Elena").password("123")
                .image("avatar-3").role(Role.USER).get());
    }

    @Override
    public Collection<User> getAll() {
        return map.values();
    }

    @Override
    public Collection<User> find(User pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, User::getId)
                        && isOk(pattern, entity, User::getImage)
                        && isOk(pattern, entity, User::getLogin)
                        && isOk(pattern, entity, User::getPassword)
                        && isOk(pattern, entity, User::getRole))
                .toList();
    }


    private <T, V> boolean isOk(T pattern, T current, Function<T, V> fieldGetter) {
        V currentFieldValue = fieldGetter.apply(current);
        return Objects
                .requireNonNullElse(fieldGetter.apply(pattern), currentFieldValue)
                .equals(currentFieldValue);
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public void create(User entity) {
        entity.setId(id.incrementAndGet());
        update(entity);
    }

    @Override
    public void update(User entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public void delete(User entity) {
        map.remove(entity.getId());
    }
}
