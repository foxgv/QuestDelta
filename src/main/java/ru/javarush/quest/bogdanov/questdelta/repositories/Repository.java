package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.User;

import java.util.List;

public interface Repository<T> {

    List<T> getAll();

    User getByID(long id);

    boolean create(T entity);

    boolean update(T entity);

    boolean delete(T entity);

}
