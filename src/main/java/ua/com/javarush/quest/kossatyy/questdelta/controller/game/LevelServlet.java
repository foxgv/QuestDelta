package ua.com.javarush.quest.kossatyy.questdelta.controller.game;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameSessionDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.LevelDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.GameSession;
import ua.com.javarush.quest.kossatyy.questdelta.entity.GameStatus;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Level;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;
import ua.com.javarush.quest.kossatyy.questdelta.service.GameService;
import ua.com.javarush.quest.kossatyy.questdelta.service.LevelService;
import ua.com.javarush.quest.kossatyy.questdelta.config.Container;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;

@WebServlet(name = "LevelServlet", value = "/level")
public class LevelServlet extends HttpServlet {

    private static final Long LOSE = -1L;
    private static final Long WIN = -2L;
    private final LevelService levelService = new LevelService();
    private final GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();

        GameSessionDto gameSessionDto = (GameSessionDto) currentSession.getAttribute(Attribute.GAME_SESSION.getValue());

        String button = req.getParameter(Attribute.BUTTON.getValue());
        Long currentLevelId = gameSessionDto.getCurrentQuestionId();
        Requirement requirement = gameSessionDto.getRequirement();
        LevelDto nextLevel;
        if (button == null) {
            nextLevel = levelService.getLevel(currentLevelId, requirement);
            gameService.updateStatus(gameSessionDto, GameStatus.PLAY);
        } else {
            int buttonNumber = Integer.parseInt(button);
            nextLevel = levelService.getLevel(currentLevelId, requirement, buttonNumber);
        }
        req.setAttribute(Attribute.LEVEL.getValue(), nextLevel);
        Long nextLevelId = nextLevel.getId();
        gameSessionDto.setCurrentQuestionId(nextLevelId);
        if (LOSE.equals(nextLevelId)) {
            gameService.updateStatus(gameSessionDto, GameStatus.LOST);
        } else if (WIN.equals(nextLevelId)) {
            gameService.updateStatus(gameSessionDto, GameStatus.WIN);
        }

        currentSession.setAttribute(Attribute.GAME_SESSION.getValue(), gameSessionDto);
        Jsp.forward(req, resp, Jsp.LEVEL);
    }
}
