package ua.com.javarush.quest.rbityutskih.repository;

import ua.com.javarush.quest.rbityutskih.entity.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class AbstractRepository<T extends Entity> implements Repository<T> {

    public static final AtomicLong id = new AtomicLong(System.currentTimeMillis());
    protected final Map<Long, T> map = new HashMap<>();

    @Override
    public Stream<T> getAll() {
        return map.values().stream();
    }

    @Override
    public abstract Stream<T> find(T pattern);


    protected <V> boolean isOk(T pattern, T current, Function<T, V> fieldGetter) {
        V currentFieldValue = fieldGetter.apply(current);
        V patternFieldValue = fieldGetter.apply(pattern);
        return Objects.isNull(patternFieldValue) || patternFieldValue.equals(currentFieldValue);
    }

    @Override
    public T get(long id) {
        return map.get(id);
    }

    @Override
    public Long create(T entity){
        Long currentId = id.incrementAndGet();
        entity.setId(currentId);
        update(entity);
        return currentId;
    }

    @Override
    public void update(T entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public void delete(T entity) {
        map.remove(entity.getId());
    }
}
