package com.javarush.khmelov.repository.impl;

import com.javarush.khmelov.entity.Game;
import com.javarush.khmelov.repository.BaseRepository;
import com.javarush.khmelov.repository.SessionCreator;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository extends BaseRepository<Game> {

    public GameRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Game.class);
    }
}
