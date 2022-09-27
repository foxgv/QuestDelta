package ru.javarush.quest.bogdanov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.services.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger();

    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> optionalUser = userService.find(login, password);
        if (optionalUser.isPresent()) {
            HttpSession session = request.getSession();
            User user = optionalUser.get();
            session.setAttribute("user", user);
            session.setAttribute("id", user.id);
            response.sendRedirect("/users");
        } else {
            request.setAttribute("error", "User not found");
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }
}
