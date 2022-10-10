package ua.com.javarush.quest.gribanov.questdelta.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.gribanov.questdelta.repository.QuestRepository;

import java.io.IOException;

@WebServlet(name = "quests", value = "/quests")
public class QuestsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("quests", QuestRepository.get().getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/quests.jsp");
        requestDispatcher.forward(req, resp);
    }
}
