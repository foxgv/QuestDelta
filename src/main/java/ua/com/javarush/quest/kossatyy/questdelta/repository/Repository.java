package ua.com.javarush.quest.kossatyy.questdelta.repository;

import java.util.Collection;
import java.util.stream.Stream;

public interface Repository<T> {
//TODO create abstract repository
    Collection<T> getAll();

    T getById(long id);

    Stream<T> find(T entity);

    void create(T entity);

    void update(T entity);

    void deleteById(long id);
}
