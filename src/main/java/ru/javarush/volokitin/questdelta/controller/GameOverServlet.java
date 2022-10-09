package ru.javarush.volokitin.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarush.volokitin.questdelta.util.JSP;

import java.io.IOException;

@WebServlet("/game_over")
public class GameOverServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSP.forward(req, resp, "game_over");
    }
}
