package ua.com.javarush.quest.kossatyy.questdelta.mapper;

import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.User;

public interface Mapper<T,V> {

    T toDto(V entity);
}
