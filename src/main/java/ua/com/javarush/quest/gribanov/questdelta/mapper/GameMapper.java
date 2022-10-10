package ua.com.javarush.quest.gribanov.questdelta.mapper;

import ua.com.javarush.quest.gribanov.questdelta.dto.ClientData;
import ua.com.javarush.quest.gribanov.questdelta.dto.GameDTO;
import ua.com.javarush.quest.gribanov.questdelta.entity.Game;


import java.util.Optional;

public class GameMapper implements Mapper<Game, GameDTO> {
    @Override
    public Optional<GameDTO>get(Game game){
        return game != null
                ? Optional.of(GameDTO.builder()
                .id(game.getId())
                .startingDate(game.getStartingDate())
                .currentQuestionID(game.getCurrentQuestionID())
                .questID(game.getQuestID())
                .userID(game.getUserID())
                .build()
        ) : Optional.empty();
    }
    @Override
    public Game create(ClientData data) {
        return null;
    }
}


