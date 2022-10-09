package ru.javarush.volokitin.questdelta.repository;

import ru.javarush.volokitin.questdelta.entity.AbstractEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public abstract class AbstractRepository<T extends AbstractEntity> {
    protected final Map<Long, T> map = new HashMap<>();

    public T get(Long id) {
        return map.get(id);
    }

    public Stream<T> getAll() {
        return map.values().stream();
    }
}
