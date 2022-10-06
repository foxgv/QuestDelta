package ua.com.javarush.quest.kossatyy.questdelta.controller.game;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameSessionDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;
import ua.com.javarush.quest.kossatyy.questdelta.service.GameService;
import ua.com.javarush.quest.kossatyy.questdelta.service.RequirementService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.ErrorMessage;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "RequirementServlet", value = "/req")
public class RequirementServlet extends HttpServlet {

    private final RequirementService requirementService = new RequirementService();
    private final GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        String paramId = req.getParameter(Attribute.ID.getValue());

        if (Objects.isNull(paramId)) {
            Jsp.forward(req, resp, Jsp.REQUIREMENT);
            return;
        }

        long requirementId;
        try {
            requirementId = Long.parseLong(paramId);
        } catch (NumberFormatException e) {
            currentSession.setAttribute(Attribute.ERROR.getValue(), ErrorMessage.REQ_ID_NOT_FOUND);
            Jsp.forward(req, resp, Jsp.REQUIREMENT);
            return;
        }
        Requirement requirement = requirementService.getById(requirementId);
        GameSessionDto gameSessionDto = (GameSessionDto) currentSession.getAttribute(Attribute.GAME_SESSION.getValue());
        gameService.updateRequirement(gameSessionDto, requirement);

        GameDto gameDto = (GameDto) currentSession.getAttribute(Attribute.GAME.getValue());
        gameService.updateLevel(gameSessionDto, gameDto.getStartLevelId());
        req.getRequestDispatcher("level").forward(req,resp);
    }
}
