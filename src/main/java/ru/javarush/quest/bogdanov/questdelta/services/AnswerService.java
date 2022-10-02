package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Answer;
import ru.javarush.quest.bogdanov.questdelta.repositories.AnswerRepository;

import java.util.List;

public enum AnswerService {

    ANSWER_SERVICE;

    private final AnswerRepository answerRepository = AnswerRepository.getInstance();

    public List<Answer> getAll() {
        return answerRepository.getAll();
    }

    public Answer getAnswer(long id) {
        return answerRepository.getByID(id);
    }

    public List<Answer> getAnswersByQuestionId(long id) {
        return answerRepository.findAnswersByQuestionId(id);
    }

    public void create(Answer answer) {
        answerRepository.create(answer);
    }
}
