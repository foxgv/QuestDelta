package ua.com.javarush.quest.rbityutskih.repository;

import ua.com.javarush.quest.rbityutskih.entity.Entity;

import java.util.stream.Stream;

public interface Repository<T extends Entity> {
    Stream<T> getAll();
    Stream<T> find(T entity);
    T get(long id);
    Long create(T entity);
    void update(T entity);
    void delete(T entity);
 }
