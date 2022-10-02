package com.javarush.quest.bulimov.questdelta.mapping;

import com.javarush.quest.bulimov.questdelta.dto.AnswerDto;
import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.GameDto;
import com.javarush.quest.bulimov.questdelta.dto.QuestionDto;
import com.javarush.quest.bulimov.questdelta.entity.AbstractEntity;
import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.entity.Game;
import com.javarush.quest.bulimov.questdelta.entity.Question;
import lombok.experimental.UtilityClass;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public interface Mapper<E extends AbstractEntity, R> {

    Optional<R> get(E entity);

    E parse(FormData formData);

    Mapper<Game, GameDto> game = new GameMapper();
    Mapper<Question, QuestionDto> question = new QuestionMapper();

    Mapper<Answer, AnswerDto> answer = new AnswerMapper();


    default E fill(E entity, FormData formData) {
        Class<? extends AbstractEntity> aClass = entity.getClass();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("set")
                    && Modifier.isPublic(method.getModifiers())
                    && method.getParameterCount() == 1
            ) {
                String name = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
                String value = formData.getParameter(name);
                if (Objects.nonNull(value)) {
                    Class<?> type = method.getParameterTypes()[0];
                    if (InnerMapForPrimitiveData.map.containsKey(type)) {
                        Object o = InnerMapForPrimitiveData.map.get(type).apply(value);
                        set(entity, aClass, name, type, o);
                    } else if (type.isEnum()) {
                        for (Object enumConstant : type.getEnumConstants()) {
                            if (enumConstant.toString().equalsIgnoreCase(value)) {
                                set(entity, aClass, name, type, enumConstant);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return entity;
    }

    @UtilityClass
    class InnerMapForPrimitiveData {
        private static final Map<Class<?>, Function<String, Object>> map = Map.of(
                int.class, Integer::parseInt,
                long.class, Long::parseLong,
                double.class, Double::parseDouble,
                Integer.class, Integer::valueOf,
                Long.class, Long::valueOf,
                Double.class, Double::valueOf,
                String.class, String::toString
        );
    }

    private static void set(Object entity, Class<? extends AbstractEntity> aClass, String name, Class<?> type, Object o) {
        try {
            String setter = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            aClass.getMethod(setter, type).invoke(entity, o);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
