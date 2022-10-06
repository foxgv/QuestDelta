package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Game;
import ru.javarush.quest.bogdanov.questdelta.entities.GameState;
import ru.javarush.quest.bogdanov.questdelta.entities.User;

import java.util.List;
import java.util.Optional;

public enum StatsService {

    STATS_SERVICE;

    private final GameService gameService = GameService.GAME_SERVICE;
    private final UserService userService = UserService.USER_SERVICE;
    private final QuestService questService = QuestService.QUEST_SERVICE;

    public String getGamesStats() {
        List<Game> all = gameService.getAll();
        return getString(all);
    }

    public String getUserLogin(Game game) {
        Optional<User> user = userService.getUser(game.userId);
        if (user.isPresent()) {
            return user.get().getLogin();
        }
        return "Unknown user";
    }

    public String getQuestName(Game game) {
        return questService.getQuestById(game.questId).getName();
    }

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
