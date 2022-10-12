package ua.com.javarush.quest.rbityutskih.repository;


import ua.com.javarush.quest.rbityutskih.entity.Game;

import java.util.Comparator;
import java.util.stream.Stream;

public class GameRepository extends AbstractRepository<Game> implements Repository<Game>{

    private static final GameRepository gameRepository = new GameRepository();
    public static GameRepository get(){
        return gameRepository;
    }

    public GameRepository(){

    }
    @Override
    public Stream<Game> find(Game pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, Game::getId)
                        && isOk(pattern, entity, Game::getUserName)
                        && isOk(pattern, entity, Game::getCurrentQuestionId)
                        && isOk(pattern, entity, Game::getState)

                )
                .sorted(Comparator.comparingLong(Game::getId));
    }
}
