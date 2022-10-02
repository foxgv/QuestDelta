package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Game;
import ru.javarush.quest.bogdanov.questdelta.repositories.GameRepository;

import java.util.List;

public enum GameService {

    GAME_SERVICE;

    private final GameRepository gameRepository = GameRepository.getInstance();

    public List<Game> getAll() {
        return gameRepository.getAll();
    }

    public void create(Game game) {
        gameRepository.create(game);
    }

    public void update(Game game) {
        gameRepository.update(game);
    }

}
