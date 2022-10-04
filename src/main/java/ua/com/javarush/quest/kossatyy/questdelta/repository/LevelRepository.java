package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.Level;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class LevelRepository implements Repository<Level>{

    private static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    private final Map<Long, Level> levels = new HashMap<>();;

    @Override
    public Collection<Level> getAll() {
        return levels.values()
                .stream()
                .toList();
    }

    @Override
    public Level getById(long id) {
        return levels.get(id);
    }

    @Override
    public Stream<Level> find(Level entity) {
        return levels.values()
                .stream()
                .filter(levelInDB -> Objects.equals(levelInDB.getName(), entity.getName()));
    }

    @Override
    public void create(Level entity) {
        if (entity.getId() == null) {
            entity.setId(id.incrementAndGet());
        }
        update(entity);
    }

    @Override
    public void update(Level entity) {
        levels.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(long id) {
        levels.remove(id);
    }
}
