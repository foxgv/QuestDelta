package ua.com.javarush.quest.kossatyy.questdelta.mapper;

import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.User;

public class UserMapper implements Mapper<UserDto, User> {

    @Override
    public UserDto toDto(User entity) {
        return UserDto.builder()
                .login(entity.getLogin())
                .role(entity.getRole())
                .build();
    }
}
