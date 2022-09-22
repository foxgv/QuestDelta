package ru.javarush.quest.bogdanov.questdelta.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.quest.bogdanov.questdelta.entities.Role;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.services.UserService;

import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = userService.getUser(Long.parseLong(id));
        request.setAttribute("user", user);
        request.getRequestDispatcher("WEB-INF/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("submit") != null) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String role = request.getParameter("select");
            User user = new User(Role.valueOf(role), login, password);
            postUser(user);
        }
        response.sendRedirect(" /users");
    }

    private void postUser(User user) {
        userService.create(user);
    }
}
