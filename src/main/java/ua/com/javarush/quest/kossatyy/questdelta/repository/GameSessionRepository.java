package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.GameSession;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class GameSessionRepository implements Repository<GameSession> {

    private static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    private final Map<Long, GameSession> sessions = new HashMap<>();

    @Override
    public Collection<GameSession> getAll() {
        return sessions.values()
                .stream()
                .toList();
    }

    @Override
    public GameSession getById(long id) {
        return sessions.get(id);
    }

    @Override
    public Stream<GameSession> find(GameSession entity) {
        return sessions.values()
                .stream()
                .filter(sessionInDb
                        -> Objects.equals(sessionInDb.getUserId(), entity.getUserId())
                        && Objects.equals(sessionInDb.getGameId(), entity.getGameId()));
    }

    @Override
    public void create(GameSession entity) {
        if (entity.getId() == null) {
            entity.setId(id.incrementAndGet());
        }
        update(entity);
    }

    @Override
    public void update(GameSession entity) {
        sessions.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(long id) {
        sessions.remove(id);
    }
}
