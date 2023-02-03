package com.javarush.khmelov.controller.game;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.GameDto;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.service.GameService;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;
import com.javarush.khmelov.util.Parser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(value = Go.GAME, name = "GameServlet")
public class GameServlet extends HttpServlet {

    private final GameService gameService = Winter.getBean(GameService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<UserDto> user = Parser.getUser(request.getSession());
        FormData formData = FormData.of(request);
        if (user.isPresent()) {
            Optional<GameDto> game = gameService.getGame(formData, user.get().getId());
            if (game.isPresent()) {
                GameDto gameDto = game.get();
                forwardToQuestion(request, response, gameDto);
            } else {
                Jsp.redirect(request, response, Go.QUESTS, "Нет незавершенной игры");
            }
        } else {
            Jsp.forward(request, response, Go.QUESTS, "Сначала нужно войти в аккаунт");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long gameId = Parser.getId(request);
        Long answerId = Parser.getId(request, Jsp.Key.ANSWER);
        Optional<GameDto> game = gameService.checkAnswer(gameId, answerId);
        if (game.isPresent()) {
            GameDto gameDto = game.get();
            if (answerId == 0) {
                request.setAttribute(Jsp.Key.ERROR_MESSAGE, "Нужно выбрать какой-то ответ");
            }
            forwardToQuestion(request, response, gameDto);
        } else {
            Jsp.forward(request, response, Go.QUESTS, "Нет такой игры");
        }
    }

    private static void forwardToQuestion(HttpServletRequest request, HttpServletResponse response, GameDto gameDto)
            throws ServletException, IOException {
        request.setAttribute(Jsp.Key.GAME, gameDto);
        request.setAttribute(Jsp.Key.QUESTION, gameDto.getQuestion());
        Jsp.forward(request, response, Go.GAME);
    }
}
