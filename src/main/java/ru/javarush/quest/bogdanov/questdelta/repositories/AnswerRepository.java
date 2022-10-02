package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Answer;

import java.util.*;
import java.util.stream.Collectors;

public class AnswerRepository implements Repository<Answer> {
    private static AnswerRepository instance;

    private final Map<Long, Answer> map = new HashMap<>();

    private AnswerRepository() {
        map.put(1L, new Answer(1L, true, "да"));
        map.put(2L, new Answer(1L, false, "нет"));

        map.put(3L, new Answer(2L, false, "тест1"));
        map.put(4L, new Answer(2L, true, "тест2"));

        map.put(5L, new Answer(3L, true, "принять вызов"));
        map.put(6L, new Answer(3L, false, "отклонить вызов"));

        map.put(7L, new Answer(5L, true, "подняться на мостик"));
        map.put(8L, new Answer(5L, false, "отказаться подниматься"));

        map.put(9L, new Answer(6L, true, "рассказать правду о себе"));
        map.put(10L, new Answer(6L, false, "солгать"));
    }

    public static AnswerRepository getInstance() {
        if (instance == null) {
            instance = new AnswerRepository();
        }
        return instance;
    }

    @Override
    public List<Answer> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Answer getByID(long id) {
        return map.get(id);
    }

    @Override
    public void create(Answer entity) {

    }

    @Override
    public void update(Answer entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Answer> find(Answer pattern) {
        return Optional.empty();
    }

    public List<Answer> findAnswersByQuestionId(long id) {
        return getAll()
                .stream()
                .filter(answer -> answer.questionId == id)
                .collect(Collectors.toList());
    }
}
