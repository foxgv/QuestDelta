package com.javarush.khmelov.mapping;

import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.entity.User;

import java.util.Optional;

/**
 * Class package-private. Use only <code>interface Mapper</code>
 */
class UserMapper implements Mapper<User, UserDto> {

    @Override
    public Optional<UserDto> get(User user) {
        return user != null
                ? Optional.of(UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .image(user.getImage())
                .role(user.getRole())
                .build()
        ) : Optional.empty();
    }

    @Override
    public User parse(FormData formData) {
        User user = User.builder().build();
        return fill(user, formData);
    }
}
