package ua.com.javarush.quest.ryabov.questdelta.dto;

import lombok.Builder;
import lombok.Data;
import ua.com.javarush.quest.ryabov.questdelta.entity.Role;

@Data
@Builder(builderMethodName = "with", buildMethodName = "get")
public class UserDto {

    Long id;

    String login;

    String image;

    Role role;

}