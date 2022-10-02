package com.javarush.quest.bulimov.questdelta.mapping;

import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.GameDto;
import com.javarush.quest.bulimov.questdelta.entity.Game;
import com.javarush.quest.bulimov.questdelta.entity.GameStatus;

import java.time.ZonedDateTime;
import java.util.Optional;

public class GameMapper implements Mapper<Game, GameDto>{
    @Override
    public Optional<GameDto> get(Game game) {
        return game != null
                ? Optional.of(GameDto.with()
                .id(game.getId())
                .questId(game.getQuestId())
                .gameStatus(game.getGameStatus())
                .currentQuestionId(game.getCurrentQuestionId())
                .startTime(game.getStartTime())
                .userName(game.getUserName())
                .build()
        ) : Optional.empty();
    }

    @Override
    public Game parse(FormData formData) {
        Game quest = Game.with().build();
        return fill(quest, formData);
    }
}
