package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class UserRepository implements Repository<User> {

    private static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    private final Map<Long, User> users = new HashMap<>();

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
        return users.values()
                .stream()
                .filter(userInDB -> Objects.equals(userInDB.getLogin(), user.getLogin()));
    }

    @Override
    public void create(User entity) {
        if (entity.getId() == null) {
            entity.setId(id.incrementAndGet());
        }
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
