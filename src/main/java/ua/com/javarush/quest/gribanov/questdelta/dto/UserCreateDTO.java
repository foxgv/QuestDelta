package ua.com.javarush.quest.gribanov.questdelta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.com.javarush.quest.gribanov.questdelta.entity.Role;

@Data
@AllArgsConstructor
public class UserCreateDTO {
    String name;
    String login;
    String password;
    Role role;
    String avatar;
}
