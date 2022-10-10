package ru.javarush.volokitin.questdelta.service;

import ru.javarush.volokitin.questdelta.repository.QuestionRepository;

public enum QuestionService {
    INSTANCE;

    private final QuestionRepository questionRepository = QuestionRepository.get();

    public long getTotalQuestionsCount() {
        return questionRepository.getAll().count();
    }
}
