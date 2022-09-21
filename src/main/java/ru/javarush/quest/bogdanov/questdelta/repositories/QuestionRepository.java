package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Question;
import ru.javarush.quest.bogdanov.questdelta.entities.User;

import java.util.List;

public class QuestionRepository implements Repository<Question> {

    @Override
    public List<Question> getAll() {
        return null;
    }

    @Override
    public User getByID(long id) {
        return null;
    }

    @Override
    public boolean create(Question entity) {
        return false;
    }

    @Override
    public boolean update(Question entity) {
        return false;
    }

    @Override
    public boolean delete(Question entity) {
        return false;
    }
}
