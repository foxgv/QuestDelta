package ua.com.javarush.quest.gribanov.questdelta.dto;

import lombok.Builder;
import lombok.Data;
import ua.com.javarush.quest.gribanov.questdelta.entity.GameState;

import java.time.ZonedDateTime;

@Data
@Builder
public class GameDTO {
    long id;
    ZonedDateTime startingDate;
    long userID;
    long currentQuestionID;
    long questID;
    GameState state;
}
