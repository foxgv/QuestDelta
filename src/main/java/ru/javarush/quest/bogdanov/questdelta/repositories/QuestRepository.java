package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Quest;
import ru.javarush.quest.bogdanov.questdelta.services.QuestionService;

import java.util.*;

public class QuestRepository implements Repository<Quest> {

    private static QuestRepository instance;

    QuestionService questionService = QuestionService.QUESTION_SERVICE;

    private final Map<Long, Quest> map = new HashMap<>();

    private QuestRepository() {
        map.put(1L, new Quest(questionService.getQuestionsByQuestId(1L), "тест квест", "тест квест", 1L));
        map.put(2L, new Quest(questionService.getQuestionsByQuestId(2L), "JR Quest", "Ты попал на корабль пришельцев. Попробуй вернуться домой живым!", 1L));
    }

    public static QuestRepository getInstance() {
        if (instance == null) {
            instance = new QuestRepository();
        }
        return instance;
    }

    @Override
    public List<Quest> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Quest getByID(long id) {
        return map.get(id);
    }

    @Override
    public void create(Quest entity) {
    }

    @Override
    public void update(Quest entity) {
        map.replace(entity.id, entity);
    }

    @Override
    public void delete(Long id) {
        map.remove(id);
    }

    @Override
    public Optional<Quest> find(Quest pattern) {
        return Optional.empty();
    }
}
