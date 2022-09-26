package ua.com.javarush.quest.khmelov.questdelta.repository;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getAll();

    T find(T template);
    T get(long id);
    boolean add(T entity);
    boolean update(T entity);
    boolean remove(T entity);
}
