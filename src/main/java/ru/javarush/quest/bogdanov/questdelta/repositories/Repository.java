package ru.javarush.quest.bogdanov.questdelta.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    List<T> getAll();

    T getByID(long id);

    void create(T entity);

    void update(T entity);

    void delete(Long id);

    Optional<T> find(T pattern);

}
