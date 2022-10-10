package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Game;
import ru.javarush.quest.bogdanov.questdelta.entities.Role;
import ru.javarush.quest.bogdanov.questdelta.entities.User;

import java.util.*;

public class UserRepository implements Repository<User> {

    private static UserRepository instance;

    private final Map<Long, User> map = new HashMap<>();

    public UserRepository() {
        map.put(1L, new User("Misha", "1111", Role.ADMIN));
        map.put(2L, new User("Sanya", "2222", Role.USER));
        map.put(3L, new User("Nastya", "3333", Role.GUEST));
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
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
                        || (x.getLogin().equals(pattern.getLogin())
                        && x.getPassword().equals(pattern.getPassword())))
                .toList()
                .stream()
                .findFirst();
    }

    public void addGame(Game game, long id) {
        User user = getByID(id);
        user.games.add(game);
        update(user);
    }
}
