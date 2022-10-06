package ua.com.javarush.quest.kossatyy.questdelta.controller.game;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameSessionDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.error.AppError;
import ua.com.javarush.quest.kossatyy.questdelta.service.GameService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {

    private final GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        UserDto user = (UserDto) currentSession.getAttribute(Attribute.USER.getValue());

        String paramGameId = req.getParameter(Attribute.GAME_ID.getValue());

        long gameId;
        try {
            gameId = Long.parseLong(paramGameId);
        } catch (NumberFormatException e) {
            // TODO replace for display error / redirect?
            throw new AppError("Wrong format gameID - " + paramGameId, e);
        }
        GameDto gameDto = gameService.getGame(gameId);
        currentSession.setAttribute(Attribute.GAME.getValue(), gameDto);

        GameSessionDto gameSessionDto = gameService.getSession(user, gameId);
        currentSession.setAttribute(Attribute.GAME_SESSION.getValue(), gameSessionDto);

        Jsp.forward(req,resp, Jsp.GAME_MENU);
    }
}
