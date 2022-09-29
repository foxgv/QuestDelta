package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Answer;
import ru.javarush.quest.bogdanov.questdelta.entities.Question;
import ru.javarush.quest.bogdanov.questdelta.services.AnswerService;

import java.util.*;
import java.util.stream.Collectors;

public class QuestionRepository implements Repository<Question> {

    AnswerService answerService = AnswerService.ANSWER_SERVICE;

    private final Map<Long, Question> map = new HashMap<>();

    public QuestionRepository() {
        map.put(1L, new Question(answerService.getAnswersByQuestionId(1L), 1L, 2L, 3L, "да или нет?"));
        map.put(2L, new Question(1L, 4L, "ты победил!"));
        map.put(3L, new Question(1L, 5L, "ты проиграл!"));
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
}
