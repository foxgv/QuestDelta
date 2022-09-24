package com.javarush.quest.bulimov.questdelta.repository;

import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.entity.Game;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public class GameRepository extends AbstractRepository<Game> implements Repository<Game>{

    public static final GameRepository gameRepository = new GameRepository();
    public static GameRepository get(){
        return gameRepository;
    }

    public GameRepository(){

    }
    @Override
    public Stream<Game> find(Game pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, Game::getId)
                        && isOk(pattern, entity, Game::getGameStatus)
                        && isOk(pattern, entity, Game::getCurrentQuestionId)
                        && isOk(pattern, entity, Game::getUserId)
                )
                .sorted(Comparator.comparingLong(Game::getId));
    }
}
