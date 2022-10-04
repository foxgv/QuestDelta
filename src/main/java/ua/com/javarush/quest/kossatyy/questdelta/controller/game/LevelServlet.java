package ua.com.javarush.quest.kossatyy.questdelta.controller.game;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.kossatyy.questdelta.service.LevelService;
import ua.com.javarush.quest.kossatyy.questdelta.config.Container;

import java.io.IOException;

@WebServlet(name = "LevelServlet", value = "/level")
public class LevelServlet extends HttpServlet {

//    private final LevelService levelService = Container.getInstance(LevelService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession currentSession = req.getSession();
//
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
