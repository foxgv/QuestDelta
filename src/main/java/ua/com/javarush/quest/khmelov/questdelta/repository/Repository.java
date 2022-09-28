package ua.com.javarush.quest.khmelov.questdelta.repository;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {
    Collection<T> getAll();

    Collection<T> find(T template);
    T get(long id);
    boolean add(T entity);
    boolean update(T entity);
    boolean remove(T entity);
}
