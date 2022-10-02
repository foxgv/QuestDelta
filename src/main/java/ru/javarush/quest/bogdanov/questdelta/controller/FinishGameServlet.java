package ru.javarush.quest.bogdanov.questdelta.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.javarush.quest.bogdanov.questdelta.entities.Game;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.services.UserService;

import java.io.IOException;

@WebServlet(name = "FinishGameServlet", value = "/finish")
public class FinishGameServlet extends HttpServlet {

    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Game game = (Game) session.getAttribute("game");
        userService.addGame(game, user.id);
        session.removeAttribute("game");
        session.removeAttribute("question");
        resp.sendRedirect("/stats");
    }
}
