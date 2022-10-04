package ua.com.javarush.quest.kossatyy.questdelta.dto;

import lombok.Builder;
import lombok.Data;
import ua.com.javarush.quest.kossatyy.questdelta.entity.GameStatus;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;

import java.util.List;

@Data
@Builder
public class GameSessionDto {

    private Long id;
    private Long userId;
    private Long gameId;
    private Long currentQuestionId;
    private Requirement requirement;
    private GameStatus gameStatus;

}
