package ua.com.javarush.quest.rbityutskih.repository;

import ua.com.javarush.quest.rbityutskih.entity.Game;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {
    private final Map<Long, Game> games;

    public GameStatistic() {
        games = new HashMap<>();
        games.put(1L, new Game());
        games.put(2L, new Game());
    }

    public Map<Long, Game> getGames() {
        return games;
    }

    /*
    public int getGamesCounter(long gameId) {
        return games.get(gameId).getGamesCount();
    }


    public int getGamesId(long gameId) {
        return games.get(gameId).getGamesWon();
    }
    */
    public void setGamesCounter(long gameId) {
        games.get(gameId).setGamesCounter();
    }

    public void setGamesId(long gameId) {
        games.get(gameId).setGamesId();
    }
}

