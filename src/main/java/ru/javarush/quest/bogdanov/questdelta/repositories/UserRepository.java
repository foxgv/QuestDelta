package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Role;
import ru.javarush.quest.bogdanov.questdelta.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User> {

    private final Map<Long, User> map = new HashMap<>();

    public UserRepository() {
        map.put(1L, new User(Role.ADMIN, "Misha", "1111"));
        map.put(2L, new User(Role.USER, "Sanya", "222"));
        map.put(3L, new User(Role.GUEST, "Nastya", "3333"));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public User getByID(long id) {
        return map.get(id);
    }

    @Override
    public void create(User entity) {
        map.put(entity.id, entity);
    }

    @Override
    public void update(User entity) {
        map.replace(entity.id, entity);
    }

    @Override
    public void delete(User entity) {
        map.remove(entity.id, entity);
    }
}
