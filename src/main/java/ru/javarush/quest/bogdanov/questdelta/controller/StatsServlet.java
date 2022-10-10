package ru.javarush.quest.bogdanov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarush.quest.bogdanov.questdelta.entities.Game;
import ru.javarush.quest.bogdanov.questdelta.services.GameService;
import ru.javarush.quest.bogdanov.questdelta.services.StatsService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StatsServlet", value = "/stats")
public class StatsServlet extends HttpServlet {

    private final GameService gameService = GameService.GAME_SERVICE;
    private final StatsService statsService = StatsService.STATS_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Game> all = gameService.getAll();
        String gamesStats = statsService.getGamesStats();
        request.setAttribute("all", all);
        request.setAttribute("gamesStats", gamesStats);
        request.getRequestDispatcher("WEB-INF/stats.jsp").forward(request, response);
    }
}
