package ua.com.javarush.quest_spring.ivanov.utils;

import org.springframework.stereotype.Component;
import ua.com.javarush.quest_spring.ivanov.entities.Game;
import ua.com.javarush.quest_spring.ivanov.entities.User;

import javax.servlet.http.HttpServletRequest;

@Component
public class GameStatsHelper {

    public void addGameStat(HttpServletRequest request, String action) {
        User user = (User) request.getSession().getAttribute("user");
        if (action.equals("gameCounter")) {
            int gameCounter = user.getGame().getGameCounter() + 1;
            user.getGame().setGameCounter(gameCounter);
        } else if (action.equals("failed")) {
            int gameFailed = user.getGame().getGameFailed() + 1;
            user.getGame().setGameFailed(gameFailed);
        } else {
            int gameCompleted = user.getGame().getGameCompleted() + 1;
            user.getGame().setGameCompleted(gameCompleted);
        }
        request.getSession().setAttribute("user", user);
    }

    public void setQuantityOfCorrectAnswers(HttpServletRequest request, String action) {
        User user = (User) request.getSession().getAttribute("user");
        Game game = user.getGame();
        int quantityOfCorrectAnswers = 0;
        if (action.equals("add")) {
            quantityOfCorrectAnswers = game.getQuantityQuizCorrectAnswers() + 1;
        }
        game.setQuantityQuizCorrectAnswers(quantityOfCorrectAnswers);
        user.setGame(game);
        request.getSession().setAttribute("user", user);
    }
}
