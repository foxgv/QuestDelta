package ua.com.javarush.quest.khmelov.questdelta.repository;

import ua.com.javarush.quest.khmelov.questdelta.entity.AbstractEntity;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public abstract class AbstractRepository<T extends AbstractEntity> implements Repository<T>{
    public final static AtomicLong id = new AtomicLong(System.currentTimeMillis());
    protected final Map<Long, T> repository = new HashMap<>();

    @Override
    public Collection<T> getAll() {
        return repository.values();
    }

    protected <V> boolean isCoincide(T template, T current, Function<T, V> fieldGetter) {
        V currentFieldValue = fieldGetter.apply(current);
        V templateFieldValue = fieldGetter.apply(template);
        return Objects.isNull(templateFieldValue) || templateFieldValue.equals(currentFieldValue);
    }

    @Override
    public abstract Collection<T> find(T template);

    @Override
    public T get(long id) {
        return repository.get(id);
    }

    @Override
    public boolean add(T entity) {
        entity.setId(id.incrementAndGet());
        if (!repository.containsKey(entity.getId())){
            repository.put(entity.getId(), entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(T entity) {
        if (repository.containsKey(entity.getId())){
            repository.put(entity.getId(), entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(T entity) {
        return repository.remove(entity.getId(), entity);
    }
}
