package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.User;

import java.util.Optional;

public interface Repository<T> {

    Optional<T> getById(long id);

    Optional<T> find(T entity);

    void add(T entity);

    void update(T entity);

    void deleteById(long id);
}
