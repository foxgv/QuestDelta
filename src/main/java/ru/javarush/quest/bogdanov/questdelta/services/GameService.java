package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Game;
import ru.javarush.quest.bogdanov.questdelta.repositories.GameRepository;
import ru.javarush.quest.bogdanov.questdelta.repositories.Repository;

import java.util.List;

public enum GameService {

    GAME_SERVICE;

    private final Repository<Game> gameRepository = new GameRepository();

    public List<Game> getAll() {
        return gameRepository.getAll();
    }

    public Game getQuestion(long id) {
        return gameRepository.getByID(id);
    }

    public void create(Game game) {
        gameRepository.create(game);
    }
}
