package ua.com.javarush.quest.gribanov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.gribanov.questdelta.constant.AppURL;
import ua.com.javarush.quest.gribanov.questdelta.dto.GameDTO;
import ua.com.javarush.quest.gribanov.questdelta.dto.UserDTO;
import ua.com.javarush.quest.gribanov.questdelta.service.GameService;
import ua.com.javarush.quest.gribanov.questdelta.service.UserService;

import java.io.IOException;
import java.util.Optional;

import static ua.com.javarush.quest.gribanov.questdelta.util.GameDispatcher.*;

@WebServlet(value = AppURL.USER_URL)
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.get();
        Optional<UserDTO> user=userService.getUser(req.getSession());
        if (user.isPresent()) {
            req.getSession().setAttribute("user", user.get());
            forwardToJSP(req, resp, PROFILE_JSP);
        } else {
            forwardToJSP(req, resp, HOME_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.get();
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<UserDTO> optionalUser = userService.createUser(name, login, password);
        if (optionalUser.isPresent()) {
            req.getSession().setAttribute("user", optionalUser.get());
            forwardToJSP(req, resp, PROFILE_JSP);
        } else {
            req.setAttribute("errorMessage", "hhh");
            resp.setStatus(401, "Не удалось создать пользователя");
            //forwardToJSP(req, resp, LOGIN_JSP);
        }
    }
}
