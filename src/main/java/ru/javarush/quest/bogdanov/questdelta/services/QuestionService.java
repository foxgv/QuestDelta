package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Question;
import ru.javarush.quest.bogdanov.questdelta.repositories.QuestionRepository;
import ru.javarush.quest.bogdanov.questdelta.repositories.Repository;

import java.util.List;

public enum QuestionService {
    QUESTION_SERVICE;

    private final Repository<Question> questionRepository = new QuestionRepository();

    public List<Question> getAll() {
        return questionRepository.getAll();
    }

    public Question getQuestion(long id) {
        return questionRepository.getByID(id);
    }

    public void create(Question question) {
        questionRepository.create(question);
    }
}
