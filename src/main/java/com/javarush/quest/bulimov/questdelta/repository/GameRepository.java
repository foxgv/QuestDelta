package com.javarush.quest.bulimov.questdelta.repository;

import com.javarush.quest.bulimov.questdelta.entity.Game;

import java.util.Collection;

public class GameRepository extends AbstractRepository<Game> implements Repository<Game>{

    public static final GameRepository gameRepository = new GameRepository();
    public static GameRepository get(){
        return gameRepository;
    }

    public GameRepository(){

    }
    @Override
    public Collection<Game> find(Game pattern) {
        return null;
    }
}
