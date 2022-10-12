package ua.com.javarush.quest.zazimko.questdelta.entity;

import lombok.*;
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "with")
public class Game {
    Long id;
    Long questId;
    Long userId;
    Long currentQuestionId;
    GameState gameState;


}
