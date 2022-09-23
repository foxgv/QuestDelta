package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.User;

import java.util.Collection;
import java.util.stream.Stream;

public interface Repository<T> {

    Collection<T> getAll();

    T getById(long id);

    Stream<User> find(T entity);

    void create(T entity);

    void update(T entity);

    void deleteById(long id);
}
