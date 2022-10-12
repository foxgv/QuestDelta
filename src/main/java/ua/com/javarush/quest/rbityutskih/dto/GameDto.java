package ua.com.javarush.quest.rbityutskih.dto;

import lombok.Builder;
import lombok.Data;
import ua.com.javarush.quest.rbityutskih.entity.GameState;

@Data
@Builder(builderMethodName = "with")
public class GameDto {
    Long id;
    Long questId;
    Long userId;
    QuestionDto question;
    GameState gameState;
}
