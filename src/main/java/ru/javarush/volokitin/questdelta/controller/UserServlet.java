package ru.javarush.volokitin.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarush.volokitin.questdelta.util.Common;
import ru.javarush.volokitin.questdelta.util.JSP;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> newGameOptional = Common.getRequestParameter(req, "new_game");
        if (newGameOptional.isPresent()) {
            req.getSession().setAttribute("curQuestionID", 0L);
            req.getSession().setAttribute("correctAnswersCount", 0);
            req.getSession().removeAttribute("user");
        }

        Optional<String> optionalUser = Optional.ofNullable((String) req.getSession().getAttribute("user"));
        if (optionalUser.isPresent()) {
            JSP.redirect(req, resp, "game");
        } else {
            JSP.forward(req, resp, "user");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> optionalUser = Common.getRequestParameter(req, "user");
        if (optionalUser.isPresent()) {
            req.getSession().setAttribute("user", optionalUser.get());
            JSP.redirect(req, resp, "game");
        } else {
            JSP.forward(req, resp, "user");
        }
    }
}
