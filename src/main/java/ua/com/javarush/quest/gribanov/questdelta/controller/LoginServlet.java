package ua.com.javarush.quest.gribanov.questdelta.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.gribanov.questdelta.constant.AppURL;
import ua.com.javarush.quest.gribanov.questdelta.dto.UserDTO;
import ua.com.javarush.quest.gribanov.questdelta.service.UserService;

import java.io.IOException;
import java.util.Optional;

import static ua.com.javarush.quest.gribanov.questdelta.util.GameDispatcher.*;

@WebServlet(name = "Login", value = AppURL.LOGIN_URL)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getSession().setAttribute("errorMessage", "Данного пользователя не существует");
        forwardToJSP(req, resp, LOGIN_JSP);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.get();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<UserDTO> optionalUser = userService.findUser(login, password);
        if (optionalUser.isPresent()) {
            req.getSession().setAttribute("user", optionalUser.get());
            forwardToJSP(req, resp, HOME_JSP);
        } else {
            req.getSession().setAttribute("errorMessage", "Данного пользователя не существует");
            resp.setStatus(200);
            forwardToJSP(req, resp, LOGIN_JSP);
        }
    }
}
