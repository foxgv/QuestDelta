package com.javarush.quest.bulimov.questdelta.controller;

import com.javarush.quest.bulimov.questdelta.services.GameService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "createServlet", value = "/create")
public class CreateServlet extends HttpServlet {
    private final GameService gameService = GameService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("id") == null){
            doPost(req, resp);
        }
        else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/game");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = gameService.create(req.getParameter("name"));
        req.getSession().setAttribute("id", id);
        doGet(req, resp);
    }
}
