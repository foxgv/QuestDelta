package ua.com.javarush.quest.ryabov.questdelta.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "with", buildMethodName = "get")
public class User {

    Long id;

    String login;

    String password;

    String image;

    Role role;

}
