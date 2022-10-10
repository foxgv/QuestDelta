package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.Game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class GameRepository implements Repository<Game> {

    private static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    private final Map<Long, Game> games = new HashMap<>();

    @Override
    public Collection<Game> getAll() {
        return games.values();
    }

    @Override
    public Game getById(long id) {
        return games.get(id);
    }

    @Override
    public Stream<Game> find(Game entity) {
        return games.values()
                .stream()
                .filter(gameInDB -> Objects.equals(gameInDB.getName(), entity.getName()));
    }

    @Override
    public void create(Game entity) {
        if (entity.getId() == null) {
            entity.setId(id.incrementAndGet());
        }
        update(entity);
    }

    @Override
    public void update(Game entity) {
        games.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(long id) {
        games.remove(id);
    }
}
