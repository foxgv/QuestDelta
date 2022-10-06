package com.javarush.quest.bulimov.questdelta.controller;

import com.javarush.quest.bulimov.questdelta.dto.FormData;
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
        if(req.getAttribute("id") == null){
            doPost(req, resp);
        }
        else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/game");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        gameService.create(FormData.of(req));
        req.setAttribute("name", gameService.find(FormData.of(req)).get().getUserName());
        req.setAttribute("id", gameService.find(FormData.of(req)).get().getId());
        doGet(req, resp);
    }
}
