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
                .text("Лямбда-выражение преобразовывается компилятором в")
                .answers(List.of(
                        AnswerRepository.get().get(0L),
                        AnswerRepository.get().get(1L),
                        AnswerRepository.get().get(2L),
                        AnswerRepository.get().get(3L)))
                .get());

        map.put(1L, Question.with()
                .id(1L)
                .text("Досрочно выйти из цикла можно с помощью оператора:")
                .answers(List.of(
                        AnswerRepository.get().get(4L),
                        AnswerRepository.get().get(5L),
                        AnswerRepository.get().get(6L),
                        AnswerRepository.get().get(7L)))
                .get());

        map.put(2L, Question.with()
                .id(2L)
                .text("«Класс» относится к «объекту» как:")
                .answers(List.of(
                        AnswerRepository.get().get(8L),
                        AnswerRepository.get().get(9L),
                        AnswerRepository.get().get(10L),
                        AnswerRepository.get().get(11L)))
                .get());

        map.put(3L, Question.with()
                .id(3L)
                .text("У примитивного типа int есть его непримитивный аналог, он называется?")
                .answers(List.of(
                        AnswerRepository.get().get(12L),
                        AnswerRepository.get().get(13L),
                        AnswerRepository.get().get(14L),
                        AnswerRepository.get().get(15L)))
                .get());

        map.put(4L, Question.with()
                .id(4L)
                .text("Если внутри блока try-with-resources возникнет ошибка, то:")
                .answers(List.of(
                        AnswerRepository.get().get(16L),
                        AnswerRepository.get().get(17L),
                        AnswerRepository.get().get(18L),
                        AnswerRepository.get().get(19L)))
                .get());

        map.put(5L, Question.with()
                .id(5L)
                .text("IDEA отображает вам имя метода перечеркнутым горизонтальной чертой. Что это значит?\n")
                .answers(List.of(
                        AnswerRepository.get().get(20L),
                        AnswerRepository.get().get(21L),
                        AnswerRepository.get().get(22L),
                        AnswerRepository.get().get(23L)))
                .get());
    }
}
