package ru.javarush.volokitin.questdelta.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarush.volokitin.questdelta.service.QuestionService;
import ru.javarush.volokitin.questdelta.util.JSP;

import java.io.IOException;

@WebServlet({"", "/quest"})
public class QuestServlet extends HttpServlet {
    private final QuestionService questionService = QuestionService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("totalQuestionsCount", questionService.getTotalQuestionsCount());
        JSP.forward(req, resp, "quest");
    }
}
