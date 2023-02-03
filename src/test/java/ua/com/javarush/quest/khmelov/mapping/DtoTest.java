package ua.com.javarush.quest.khmelov.mapping;

import com.javarush.khmelov.mapping.Dto;
import org.junit.jupiter.api.Test;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;

class DtoTest {

    private final Dto mapper = Dto.MAPPER;

    @Test
    void getDto() {
        User user = User.builder().id(1L).role(Role.ADMIN).build();
        UserDto userDto = mapper.to(user);
        System.out.println(userDto);
    }
}