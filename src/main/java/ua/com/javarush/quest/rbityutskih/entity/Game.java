package ua.com.javarush.quest.rbityutskih.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class Game extends  Entity {
    Long id;
    String userName;
    LocalDateTime startTime;
    Long currentQuestionId;
    Long questId;
    GameState state;
}
