package com.javarush.quest.bulimov.questdelta.mapping;

import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.UserDto;
import com.javarush.quest.bulimov.questdelta.entity.User;
import com.javarush.quest.bulimov.questdelta.entity.UserRole;

import java.util.Optional;

public class UserMapper implements Mapper<User, UserDto>{
    @Override
    public Optional<UserDto> get(User user) {
        return user != null
                ? Optional.of(UserDto.with()
                .id(user.getId())
                .login(user.getLogin())
                .role(user.getRole())
                .build()
        ) : Optional.empty();
    }

    @Override
    public User parse(FormData formData) {
        if(!formData.getParameter("login").isEmpty()){
            return User.with()
                    .login(formData.getParameter("login"))
                    .password(formData.getParameter("password"))
                    .role(UserRole.USER).build();
        }
        return null;
    }
}
