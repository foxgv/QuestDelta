package ru.javarush.quest.bogdanov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.services.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersServlet", value = "/users")
public class UsersServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger();

    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> all = userService.getAll();
        request.setAttribute("all", all);
        request.getRequestDispatcher("WEB-INF/users.jsp").forward(request, response);
    }
}
