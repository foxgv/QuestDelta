package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Game;
import ru.javarush.quest.bogdanov.questdelta.entities.GameState;
import ru.javarush.quest.bogdanov.questdelta.repositories.GameRepository;

import java.util.List;

public enum StatsService {

    STATS_SERVICE;

    private final GameRepository gameRepository = GameRepository.getInstance();
    //private final UserRepository userRepository = new UserRepository();

    public String getGamesStats() {
        List<Game> all = gameRepository.getAll();
        return getString(all);
    }

    //TODO допилить метод
    /*public List<String> getUsersGamesStats() {
        return userRepository.getAll().stream().map(user -> getString(user.games)).collect(Collectors.toList());
    }*/

    private String getString(List<Game> games) {
        int wins = games.stream()
                .filter(game -> game.gameState == GameState.WIN)
                .toList()
                .size();
        int looses = games.stream()
                .filter(game -> game.gameState == GameState.LOSE)
                .toList()
                .size();
        return "Всего игр сыграно: " + games.size() + ", из них выиграно: " + wins + ", проиграно: " + looses;
    }
}
