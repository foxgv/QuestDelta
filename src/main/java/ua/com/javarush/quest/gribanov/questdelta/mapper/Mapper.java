package ua.com.javarush.quest.gribanov.questdelta.mapper;

import ua.com.javarush.quest.gribanov.questdelta.dto.*;
import ua.com.javarush.quest.gribanov.questdelta.entity.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public interface Mapper <E extends AbstractEntity, R> {

    Optional<R> get(E entity);

    Mapper<User, UserDTO> user = new UserMapper();
    Mapper<Quest, QuestDTO> quest = new QuestMapper();
    Mapper<Question, QuestionDTO> question = new QuestionMapper();
    Mapper<Answer, AnswerDTO> answer = new AnswerMapper();
    Mapper<Game, GameDTO> game = new GameMapper();

    private static void set(Object entity, Class<? extends AbstractEntity> aClass, String name, Class<?> type, Object o) {
        try {
            String setter = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            aClass.getMethod(setter, type).invoke(entity, o);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
