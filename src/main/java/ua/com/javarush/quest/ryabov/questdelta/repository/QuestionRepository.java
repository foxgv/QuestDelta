package ua.com.javarush.quest.ryabov.questdelta.repository;

import ua.com.javarush.quest.ryabov.questdelta.entity.Answer;
import ua.com.javarush.quest.ryabov.questdelta.entity.Question;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class QuestionRepository implements Repository<Question> {
    public static final AtomicLong id = new AtomicLong(System.currentTimeMillis());
    private final Map<Long, Question> map = new HashMap<>();
    public static final QuestionRepository questionRepository = new QuestionRepository();

    public static QuestionRepository get() {
        return questionRepository;
    }

    QuestionRepository() {
        map.put(2L, Question.with()
                .questionID(2L).question("Пару дней назад ты выложил свое резюме на сайте и вот раздался звонок… " +
                        "Ты поднимаешь трубку и слышишь приглашение на работу. \n" +
                        "Вот и подошел день собеседования.\n" +
                        "Ты познакомил потенциальных коллег со своей биографией и началось техническое интервью.\n")
                .answers(List.of(
                        Answer.with().id(1L).answer("Приступим")
                                .nextQuestionID(3L).get(),
                        Answer.with().id(2L).answer("Памагите..." + "&#128557;")
                                .nextQuestionID(3L).get()
                )).get());
        map.put(3L, Question.with()
                .questionID(3L).question("Вас просят назвать  основные принципы ООП")
                .answers(List.of(
                        Answer.with().id(1L).answer("Абстракция, инкапсуляция, наследование, полиморфизм")
                                .nextQuestionID(6L).get(),
                        Answer.with().id(1L).answer("Фрустрация, прокрастинация, имплементация")
                                .nextQuestionID(4L).get(),
                        Answer.with().id(2L).answer("Анализ, аккумулирование, отсутствие")
                                .nextQuestionID(4L).get()
                )).get());
        map.put(4L, Question.with()
                .questionID(4L).question("Интервьюер удивлен Вашему ответу и задает решающий вопрос: Что такое ООП?")
                .answers(List.of(
                        Answer.with().id(1L).answer("Объектно-ориентированное программирование")
                                .nextQuestionID(6L).get(),
                        Answer.with().id(2L).answer("Очень одинокий программист.")
                                .nextQuestionID(5L).get(),
                        Answer.with().id(3L).answer("Общество охраны природы")
                                .nextQuestionID(5L).get(),
                        Answer.with().id(4L).answer("Отдел обслуживания покупателей")
                                .nextQuestionID(5L).get()
                )).get());
        map.put(5L, Question.with()
                .questionID(5L)
                .question("На этом интервью заканчивается, а Вам рекомендуют немного подтянуть теорию")
                .get());
        map.put(6L, Question.with()
                .questionID(6L).question("Далее Вам задают вопрос: Что такое инкапсуляция?")
                .answers(List.of(
                        Answer.with().id(1L).answer("Возможность подтипам вести себя как супертипы")
                                .nextQuestionID(7L).get(),
                        Answer.with().id(2L).answer("Механизм сокрытия внутреннего устройства объектов для контроля за доступом")
                                .nextQuestionID(8L).get(),
                        Answer.with().id(3L).answer("Частный случай множественного наследования," +
                                        " в котором участвуют родительские классы")
                                .nextQuestionID(8L).get()
                )).get());
        map.put(7L, Question.with()
                .questionID(7L).question("А в чем отличие String от StringBuilder?")
                .answers(List.of(
                        Answer.with().id(1L).answer("В окончании Builder")
                                .nextQuestionID(5L).get(),
                        Answer.with().id(2L).answer("String - неизменяемый класс, а StringBuilder - изменяемый")
                                .nextQuestionID(9L).get(),
                        Answer.with().id(3L).answer("Это два одинаковых класса и нет никакой разницы")
                                .nextQuestionID(5L).get()
                )).get());
        map.put(8L, Question.with()
                .questionID(8L).question("Следующий вопрос: Что такое String pool?")
                .answers(List.of(
                        Answer.with().id(1L).answer("Пул строк - место, где хранятся строки")
                                .nextQuestionID(7L).get(),
                        Answer.with().id(2L).answer("Разновидность бильярда")
                                .nextQuestionID(5L).get()
                )).get());
        map.put(9L, Question.with()
                .questionID(9L).question("Собрав все выше сказанное о Вас сделали вывод," +
                        " что Вы хороший специалист и компания нуждается в Вас.")
                .get());
        map.put(10L, Question.with()
                .questionID(10L).question("На техническом интервью Вы ошиблись 1 раз," +
                        " но все списали на волнение и Вас взяли, поздравляю!!!")
                .get());
        map.put(11L, Question.with()
                .questionID(11L).question("Вы ошиблись 2 раза. Вам сказали," +
                        " что им стоит обсудить результат с руководителем и Вам перезвонят." +
                        " Осталось ждать и надеяться… ")
                .get());
    }

    @Override
    public Collection<Question> getAll() {
        return map.values();
    }

    @Override
    public Collection<Question> find(Question entity) {
        //TODO ДОБАВИТЬ РЕАЛИЗАЦИЮ
        return null;
    }

    public Question find(long id) {
        return map.get(id);
    }

    @Override
    public Optional<Question> get(long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public void create(Question entity) {
        entity.setQuestionID(id.incrementAndGet());
        update(entity);
    }

    @Override
    public void update(Question entity) {
        map.put(entity.getQuestionID(), entity);
    }

    @Override
    public void delete(Question entity) {
        map.remove(entity.getQuestionID());
    }
}
