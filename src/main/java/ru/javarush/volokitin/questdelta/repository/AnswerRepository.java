package ru.javarush.volokitin.questdelta.repository;

import ru.javarush.volokitin.questdelta.entity.Answer;

public class AnswerRepository extends AbstractRepository<Answer> {
    private static final AnswerRepository answerRepository = new AnswerRepository();
    public static AnswerRepository get() {
        return answerRepository;
    }

    private AnswerRepository() {
        map.put(0L, Answer.with()
                .id(0L)
                .text("Да")
                .isCorrect(true)
                .nextQuestionId(1L)
                .get());

        map.put(1L, Answer.with()
                .id(1L)
                .text("Нет")
                .isCorrect(false)
                .nextQuestionId(null)
                .get());

        map.put(2L, Answer.with()
                .id(2L)
                .text("Вверх")
                .isCorrect(true)
                .nextQuestionId(null)
                .get());

        map.put(3L, Answer.with()
                .id(3L)
                .text("Вниз")
                .isCorrect(false)
                .nextQuestionId(null)
                .get());
    }

}
