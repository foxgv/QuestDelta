package com.javarush.quest.bulimov.questdelta.mapping;

import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.UserDto;
import com.javarush.quest.bulimov.questdelta.entity.AbstractEntity;
import com.javarush.quest.bulimov.questdelta.entity.User;


import java.util.Optional;

public interface Mapper<E extends AbstractEntity, R> {

    Optional<R> get(E entity);

    E parse(FormData formData);
    Mapper<User, UserDto> user = new UserMapper();

}
