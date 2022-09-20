package com.javarush.quest.bulimov.questdelta.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.management.relation.Role;
import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class User extends AbstractEntity{
    Long id;
    String login;
    String password;
    Role role;
    Collection<Game> games;
    Collection<Quest> quests;
}
