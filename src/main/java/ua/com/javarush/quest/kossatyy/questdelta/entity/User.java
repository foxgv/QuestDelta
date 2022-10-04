package ua.com.javarush.quest.kossatyy.questdelta.entity;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class User {

    private Long id;
    private String login;
    private String password;
    private Role role;

    final List<Game> createdGame = new ArrayList<>();
    final List<Long> gamesIdWithSession = new ArrayList<>();

}
