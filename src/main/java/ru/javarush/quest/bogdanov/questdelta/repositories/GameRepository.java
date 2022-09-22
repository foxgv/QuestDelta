package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRepository implements Repository<Game> {

    private final Map<Long, Game> map = new HashMap<>();
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

    }

    @Override
    public void update(Game entity) {

    }

    @Override
    public void delete(Game entity) {

    }
}
