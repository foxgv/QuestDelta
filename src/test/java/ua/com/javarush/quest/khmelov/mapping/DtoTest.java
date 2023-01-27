package ua.com.javarush.quest.khmelov.mapping;

import org.junit.jupiter.api.Test;
import ua.com.javarush.quest.khmelov.dto.ui.UserDto;
import ua.com.javarush.quest.khmelov.entity.Role;
import ua.com.javarush.quest.khmelov.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class DtoTest {

    private final Dto mapper = Dto.MAPPER;

    @Test
    void getDto() {
        User user = User.builder().id(1L).role(Role.ADMIN).build();
        UserDto userDto = mapper.to(user);
        System.out.println(userDto);
    }
}