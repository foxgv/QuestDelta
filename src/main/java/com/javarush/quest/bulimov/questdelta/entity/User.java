package com.javarush.quest.bulimov.questdelta.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "with")
public final class User extends AbstractEntity {

    Long id;

    String login;

    String password;

    UserRole role;

    final Collection<Game> games = new ArrayList<>(); //as user

    final Collection<Quest> quests = new ArrayList<>(); //as author (admin)

}

