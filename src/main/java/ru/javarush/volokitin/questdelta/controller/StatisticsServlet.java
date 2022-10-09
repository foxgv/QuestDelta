package ru.javarush.volokitin.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarush.volokitin.questdelta.dto.GameDTO;
import ru.javarush.volokitin.questdelta.service.GameService;
import ru.javarush.volokitin.questdelta.util.JSP;

import java.io.IOException;
import java.util.Collection;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {
    private final GameService gameService = GameService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<GameDTO> statistics = gameService.getStatistics();
        req.setAttribute("statistics", statistics);
        JSP.forward(req, resp, "statistics");
    }
}
