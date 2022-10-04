package ua.com.javarush.quest.kossatyy.questdelta.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameSession {

    private Long id;
    private Long userId;
    private Long gameId;
    private Long currentQuestionId;
    private Requirement requirement;
    private GameStatus gameStatus;

}
