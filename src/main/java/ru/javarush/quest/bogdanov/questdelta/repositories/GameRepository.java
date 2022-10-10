package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Game;

import java.util.*;

public class GameRepository implements Repository<Game> {

    private static GameRepository instance;

    private final Map<Long, Game> map = new HashMap<>();

    private GameRepository() {
        map.put(1L, new Game(1L, 1L));
    }

    public static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
        }
        return instance;
    }

    @Override
    public List<Game> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Game getByID(long id) {
        return map.get(id);
    }

    @Override
    public void create(Game entity) {
        map.put(entity.id, entity);
    }

    @Override
    public void update(Game entity) {
        map.replace(entity.id, entity);
    }

    @Override
    public void delete(Long id) {
        map.remove(id);
    }

    @Override
    public Optional<Game> find(Game pattern) {
        return Optional.empty();
    }
}
