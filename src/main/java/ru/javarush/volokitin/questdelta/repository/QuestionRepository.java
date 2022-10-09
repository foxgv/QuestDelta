package ru.javarush.volokitin.questdelta.repository;

import ru.javarush.volokitin.questdelta.entity.Question;

import java.util.List;

public class QuestionRepository extends AbstractRepository<Question> {
    private static final QuestionRepository questionRepository = new QuestionRepository();
    public static QuestionRepository get() {
        return questionRepository;
    }

    private QuestionRepository() {
        map.put(0L, Question.with()
                .id(0L)
                .text("Вопрос да или нет?")
                .answers(List.of(
                        AnswerRepository.get().get(0L),
                        AnswerRepository.get().get(1L)))
                .get());

        map.put(1L, Question.with()
                .id(1L)
                .text("Вопрос вверх или вниз?")
                .answers(List.of(
                        AnswerRepository.get().get(2L),
                        AnswerRepository.get().get(3L)))
                .get());
    }
}
