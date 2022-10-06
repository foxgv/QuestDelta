package ua.com.javarush.quest.kossatyy.questdelta.controller.game;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameSessionDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.LevelDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.GameStatus;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;
import ua.com.javarush.quest.kossatyy.questdelta.service.GameService;
import ua.com.javarush.quest.kossatyy.questdelta.service.LevelService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Objects;

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
        Requirement requirement = gameSessionDto.getRequirement();
        Long currentLevelId = gameSessionDto.getCurrentQuestionId();
        LevelDto nextLevel = null;
        if (button == null) {
            nextLevel = levelService.getLevel(currentLevelId, requirement);
            gameService.updateStatus(gameSessionDto, GameStatus.PLAY);
        } else {
            int buttonNumber = Integer.parseInt(button);
            Long nextLevelId = levelService.getNextLevelId(currentLevelId, requirement, buttonNumber);
            if (LOSE.equals(nextLevelId)) {
                gameService.updateStatus(gameSessionDto, GameStatus.LOST);
            } else if (WIN.equals(nextLevelId)) {
                gameService.updateStatus(gameSessionDto, GameStatus.WIN);
            } else {
                nextLevel = levelService.getLevel(nextLevelId, requirement);
                gameService.updateLevel(gameSessionDto, nextLevelId);
            }
        }

        if (Objects.nonNull(nextLevel)){
            req.setAttribute(Attribute.LEVEL.getValue(), nextLevel);
        Jsp.forward(req, resp, Jsp.LEVEL);
        } else {
            req.getRequestDispatcher("game?gameId="+gameSessionDto.getGameId()).forward(req,resp);
        }
    }
}
