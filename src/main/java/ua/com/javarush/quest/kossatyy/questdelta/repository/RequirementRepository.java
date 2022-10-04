package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.Button;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class RequirementRepository implements Repository<Requirement>{

    private static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    private final Map<Long, Requirement> requirements = new HashMap<>();;

    @Override
    public Collection<Requirement> getAll() {
        return requirements.values()
                .stream()
                .toList();
    }

    @Override
    public Requirement getById(long id) {
        return requirements.get(id);
    }

    @Override
    public Stream<Requirement> find(Requirement entity) {
        return requirements.values()
                .stream()
                .filter(reqInDb -> Objects.equals(reqInDb.getName(), entity.getName()));
    }

    @Override
    public void create(Requirement entity) {
        if (entity.getId() == null) {
            entity.setId(id.incrementAndGet());
        }
        update(entity);
    }

    @Override
    public void update(Requirement entity) {
        requirements.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(long id) {
        requirements.remove(id);
    }
}
