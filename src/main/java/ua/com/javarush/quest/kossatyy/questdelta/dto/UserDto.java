package ua.com.javarush.quest.kossatyy.questdelta.dto;

import lombok.Builder;
import lombok.Data;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Role;

@Data
@Builder
public class UserDto{
    private Long id;
    private String login;
    private Role role;
}

