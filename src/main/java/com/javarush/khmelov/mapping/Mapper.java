package com.javarush.khmelov.mapping;

import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.*;
import com.javarush.khmelov.entity.*;
import lombok.experimental.UtilityClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * Mapper Entity -> DTO and fill from Request -> Entity
 */
public interface Mapper<E extends AbstractEntity, R> {

    /**
     * form Service to Servlet layer
     *
     * @param entity from DB
     * @return DTO
     */
    Optional<R> get(E entity);

    /**
     * Data form Servlet convert to new Entity
     *
     * @param formData wrapper for HTTP-request
     * @return entity for DB
     */
    E parse(FormData formData);

    //all mappers
    Mapper<User, UserDto> user = new UserMapper();
    Mapper<Quest, QuestDto> quest = new QuestMapper();
    Mapper<Question, QuestionDto> question = new QuestionMapper();
    Mapper<Answer, AnswerDto> answer = new AnswerMapper();
    Mapper<Game, GameDto> game = new GameMapper();

    /**
     * Data form Servlet convert to existing instance Entity
     * demo fill with Reflection API (not easy)
     *
     * @param formData wrapper for HTTP-request
     * @return existing entity
     */
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

