package ua.com.javarush.quest.rbityutskih.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder(builderMethodName = "with")
public class UserDto {

    Long id;

    String login;

    String image;



}