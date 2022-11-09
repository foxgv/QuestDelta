package ua.com.javarush.quest.gribanov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.gribanov.questdelta.constant.AppURL;
import ua.com.javarush.quest.gribanov.questdelta.repository.QuestRepository;
import ua.com.javarush.quest.gribanov.questdelta.service.QuestService;

import java.io.IOException;

import static ua.com.javarush.quest.gribanov.questdelta.util.GameDispatcher.*;

@WebServlet(name = "quests", value = AppURL.QUESTS_URL)
public class QuestsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QuestService questService = QuestService.get();
        req.setAttribute("quests", questService.getAll());
        forwardToJSP(req, resp, QUESTS_JSP);
    }
}
