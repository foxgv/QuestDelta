package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Answer;
import ru.javarush.quest.bogdanov.questdelta.entities.Question;
import ru.javarush.quest.bogdanov.questdelta.services.AnswerService;

import java.util.*;
import java.util.stream.Collectors;

public class QuestionRepository implements Repository<Question> {

    private static QuestionRepository instance;

    AnswerService answerService = AnswerService.ANSWER_SERVICE;

    private final Map<Long, Question> map = new HashMap<>();

    private QuestionRepository() {
        map.put(1L, new Question(answerService.getAnswersByQuestionId(1L), 1L, 2L, 3L, "да или нет?"));
        map.put(2L, new Question(1L, "ты победил!"));
        map.put(3L, new Question(1L, "ты проиграл!"));

        map.put(4L, new Question(answerService.getAnswersByQuestionId(3L), 2L, 5L, 6L, "Ты потерял память. Принять вызов НЛО?"));
        map.put(5L, new Question(answerService.getAnswersByQuestionId(5L), 2L, 7L, 8L, "Ты принимаешь вызов. Поднимаешься на мостик к капитану?"));
        map.put(6L, new Question(2L, "Ты отклонил вызов. Поражение"));
        map.put(7L, new Question(answerService.getAnswersByQuestionId(6L), 2L, 9L, 10L, "Ты поднялся на мостик. Ты кто?"));
        map.put(8L, new Question(2L, "Ты не пошел на переговоры. Поражение"));
        map.put(9L, new Question(2L, "Тебя вернули домой! Победа"));
        map.put(10L, new Question(2L, "Твою ложь разоблачили! Поражение"));
    }

    public static QuestionRepository getInstance() {
        if (instance == null) {
            instance = new QuestionRepository();
        }
        return instance;
    }

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
    public void delete(Long id) {
        map.remove(id);
    }

    @Override
    public Optional<Question> find(Question pattern) {
        return Optional.empty();
    }

    public List<Question> findQuestionsByQuestId(long id) {
        return getAll()
                .stream()
                .filter(answer -> answer.questId == id)
                .collect(Collectors.toList());
    }

    public Question findQuestionByAnswer(long questionId, long answerId) {
        Answer answer = answerService.getAnswer(answerId);
        if (answer.isCorrect()) {
            return getByID(getByID(questionId).getCorrectQuestionId());
        } else {
            return getByID(getByID(questionId).getIncorrectQuestionId());
        }
    }

    public long getFirstQuestionId(long id) {
        return findQuestionsByQuestId(id).stream().findFirst().get().id;
    }
}
