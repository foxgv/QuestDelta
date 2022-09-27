package com.javarush.quest.bulimov.questdelta.dto;

import com.javarush.quest.bulimov.questdelta.entity.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "with")
public class UserDto {

    Long id;

    String login;

    String image;

    UserRole role;

}
