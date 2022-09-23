package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Role;
import ru.javarush.quest.bogdanov.questdelta.entities.User;

import java.util.*;

public class UserRepository implements Repository<User> {

    private final Map<Long, User> map = new HashMap<>();

    public UserRepository() {
        map.put(1L, new User("Misha", "1111", Role.ADMIN));
        map.put(2L, new User("Sanya", "2222", Role.USER));
        map.put(3L, new User("Nastya", "3333", Role.GUEST));
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
    public void delete(Long id) {
        map.remove(id);
    }

    @Override
    public Optional<User> find(User pattern) {
        return map.values()
                .stream()
                .filter(x -> x.getLogin().equals(pattern.getLogin())
                        && x.getPassword().equals(pattern.getPassword()))
                .toList()
                .stream()
                .findFirst();
    }
}
