package ua.com.javarush.quest.kossatyy.questdelta.mapper;

import ua.com.javarush.quest.kossatyy.questdelta.dto.GameSessionDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.GameSession;

public class GameSessionMapper implements Mapper<GameSessionDto, GameSession> {

    @Override
    public GameSessionDto toDto(GameSession entity) {
        return GameSessionDto.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .gameId(entity.getGameId())
                .currentQuestionId(entity.getCurrentQuestionId())
                .requirement(entity.getRequirement())
                .gameStatus(entity.getGameStatus())
                .build();
    }
}
