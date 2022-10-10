package ua.com.javarush.quest.belyasnik.questdelta.entities;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class User extends Entity {
    Long id;
    String login;
    String password;
    int questStatus;
}

