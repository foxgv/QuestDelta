package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionRepository implements Repository<Question> {

    private final Map<Long, Question> map = new HashMap<>();

    @Override
    public List<Question> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Question getByID(long id) {
        return map.get(id);
    }

    @Override
    public void create(Question entity) {
    }

    @Override
    public void update(Question entity) {
        map.replace(entity.id, entity);
    }

    @Override
    public void delete(Question entity) {
        map.remove(entity.id, entity);
    }
}
