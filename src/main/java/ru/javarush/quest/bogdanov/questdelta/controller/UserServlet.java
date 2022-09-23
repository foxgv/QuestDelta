package ru.javarush.quest.bogdanov.questdelta.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.quest.bogdanov.questdelta.entities.Role;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.services.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Optional<User> user = userService.getUser(Long.parseLong(id));
        user.ifPresent(value -> request.setAttribute("user", value));
        request.getRequestDispatcher("WEB-INF/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long userId = getUserId(request);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Role select = Role.valueOf(request.getParameter("select"));
        postUser(request, userId, login, password, select);
        response.sendRedirect(" /users");
    }

    private void postUser(HttpServletRequest request, long id, String login, String password, Role select) {
        boolean userCheck = userService.getUser(getUserId(request)).isPresent();
        if (!userCheck && request.getParameter("create") != null) {
            userService.create(login, password, select);
        } else if (userCheck && request.getParameter("delete") != null) {
            userService.delete(id);
        } else if (userCheck && request.getParameter("update") != null) {
            userService.update(id, login, password, select);
        }
    }

    private Long getUserId(HttpServletRequest request) {
        System.out.println(request.getParameter("id"));
        return request.getParameter("id") != null
                ? Long.parseLong("0" + request.getParameter("id"))
                : 0L;
    }
}
