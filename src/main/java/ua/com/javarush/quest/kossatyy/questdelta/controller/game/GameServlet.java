package ua.com.javarush.quest.kossatyy.questdelta.controller.game;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.kossatyy.questdelta.config.Container;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameSessionDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.GameSession;
import ua.com.javarush.quest.kossatyy.questdelta.error.AppError;
import ua.com.javarush.quest.kossatyy.questdelta.service.GameService;
import ua.com.javarush.quest.kossatyy.questdelta.service.LevelService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;

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
            throw new AppError("Wrong format gameID - " + paramGameId, e);
        }

        GameSessionDto gameSessionDto = gameService.getSession(user, gameId);
        currentSession.setAttribute(Attribute.GAME_SESSION.getValue(), gameSessionDto);

//        Requirement requirement = (Requirement) currentSession.getAttribute("req");
////
//        String button = requirement.getParameter("button");

//        Long levelId = (Long) currentSession.getAttribute("levelId");
//        Requirement requirement = (Requirement) currentSession.getAttribute("req");
//
//        String button = requirement.getParameter("button");
//
//        Level nextLevel;
//        if (button == null){
//            nextLevel = levelService.getLevel(levelId);
//        } else {
//            int buttonId = Integer.parseInt(requirement.getParameter("button"));
//            nextLevel = levelService.getNextLevel(requirement, levelId, buttonId);
//        }
//        if (nextLevel == null) {
//            RequestDispatcher requestDispatcher = requirement.getRequestDispatcher("/element");
//            requestDispatcher.forward(requirement, resp);
//        } else {
//            requirement.setAttribute("level", nextLevel);
//            currentSession.setAttribute("levelId", nextLevel.getId());
//            currentSession.setAttribute("levelName", nextLevel.getName());
//
//            RequestDispatcher requestDispatcher = requirement.getRequestDispatcher("/level.jsp");
//            requestDispatcher.forward(requirement, resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
