package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Question;
import ru.javarush.quest.bogdanov.questdelta.repositories.QuestionRepository;

import java.util.List;

public enum QuestionService {
    QUESTION_SERVICE;

    private final QuestionRepository questionRepository = new QuestionRepository();

    public Question getQuestion(long id) {
        return questionRepository.getByID(id);
    }

    public List<Question> getAll() {
        return questionRepository.getAll();
    }

    public List<Question> getQuestionsByQuestId(long id) {
        return questionRepository.findQuestionsByQuestId(id);
    }

    public void create(Question question) {
        questionRepository.create(question);
    }


}
