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
                .text("В анонимный внутренний класс")
                .isCorrect(true)
                .nextQuestionId(1L)
                .get());

        map.put(1L, Answer.with()
                .id(1L)
                .text("В специальный метод")
                .isCorrect(false)
                .nextQuestionId(1L)
                .get());

        map.put(2L, Answer.with()
                .id(2L)
                .text("В специальный объект")
                .isCorrect(false)
                .nextQuestionId(1L)
                .get());

        map.put(3L, Answer.with()
                .id(3L)
                .text("В специальный интерфейс")
                .isCorrect(false)
                .nextQuestionId(1L)
                .get());

        map.put(4L, Answer.with()
                .id(4L)
                .text("exit;")
                .isCorrect(false)
                .nextQuestionId(2L)
                .get());

        map.put(5L, Answer.with()
                .id(5L)
                .text("returned;")
                .isCorrect(false)
                .nextQuestionId(2L)
                .get());

        map.put(6L, Answer.with()
                .id(6L)
                .text("break;")
                .isCorrect(true)
                .nextQuestionId(3L)
                .get());

        map.put(7L, Answer.with()
                .id(7L)
                .text("continue;")
                .isCorrect(false)
                .nextQuestionId(2L)
                .get());

        map.put(8L, Answer.with()
                .id(8L)
                .text("\"Город\" к \"Карте города\"")
                .isCorrect(false)
                .nextQuestionId(4L)
                .get());

        map.put(9L, Answer.with()
                .id(9L)
                .text("\"Карта города\" к \"Городу\"")
                .isCorrect(false)
                .nextQuestionId(4L)
                .get());

        map.put(10L, Answer.with()
                .id(10L)
                .text("\"Рецепт печенья\" к \"Печенью\"")
                .isCorrect(true)
                .nextQuestionId(4L)
                .get());

        map.put(11L, Answer.with()
                .id(11L)
                .text("\"Печенье\" к \"Рецепту печенья\"")
                .isCorrect(false)
                .nextQuestionId(4L)
                .get());

        map.put(12L, Answer.with()
                .id(12L)
                .text("Int")
                .isCorrect(false)
                .nextQuestionId(4L)
                .get());

        map.put(13L, Answer.with()
                .id(13L)
                .text("Integer")
                .isCorrect(true)
                .nextQuestionId(4L)
                .get());

        map.put(14L, Answer.with()
                .id(14L)
                .text("Number")
                .isCorrect(false)
                .nextQuestionId(4L)
                .get());

        map.put(15L, Answer.with()
                .id(15L)
                .text("IntWrapper")
                .isCorrect(false)
                .nextQuestionId(4L)
                .get());

        map.put(16L, Answer.with()
                .id(16L)
                .text("Исключение автоматически обработается")
                .isCorrect(false)
                .nextQuestionId(5L)
                .get());

        map.put(17L, Answer.with()
                .id(17L)
                .text("Исключение будет автоматически логировано")
                .isCorrect(false)
                .nextQuestionId(5L)
                .get());

        map.put(18L, Answer.with()
                .id(18L)
                .text("У объекта-ресурса автоматически вызовется метод close()")
                .isCorrect(true)
                .nextQuestionId(5L)
                .get());

        map.put(19L, Answer.with()
                .id(19L)
                .text("Объект-ресурс автоматически удалится")
                .isCorrect(false)
                .nextQuestionId(5L)
                .get());

        map.put(20L, Answer.with()
                .id(20L)
                .text("Метод нельзя использовать")
                .isCorrect(false)
                .nextQuestionId(null)
                .get());

        map.put(21L, Answer.with()
                .id(21L)
                .text("Такой метод отсутствует")
                .isCorrect(false)
                .nextQuestionId(null)
                .get());

        map.put(22L, Answer.with()
                .id(22L)
                .text("Такой метод будет удален в следующей версии Java")
                .isCorrect(false)
                .nextQuestionId(null)
                .get());

        map.put(23L, Answer.with()
                .id(23L)
                .text("Метод не рекомендуется использовать")
                .isCorrect(true)
                .nextQuestionId(null)
                .get());
    }

}
