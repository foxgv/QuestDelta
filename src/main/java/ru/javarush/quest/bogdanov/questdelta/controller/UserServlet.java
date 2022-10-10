package ru.javarush.quest.bogdanov.questdelta.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarush.quest.bogdanov.questdelta.entities.Role;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.services.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "UserServlet", value = {"/user", "/profile", "/signup"})
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initServletContext();
        Optional<User> user = userService.getUser(getUserId(request));
        user.ifPresent(value -> request.setAttribute("user", value));
        request.getRequestDispatcher("WEB-INF/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long userId = getUserId(request);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Role select = Role.valueOf(request.getParameter("select"));
        if (postUser(request, userId, login, password, select)) {
            response.sendRedirect("/users");
        } else {
            request.getRequestDispatcher("WEB-INF/user.jsp").forward(request, response);
        }
    }

    private boolean postUser(HttpServletRequest request, long id, String login, String password, Role select) {
        boolean userCheck = userService.getUser(getUserId(request)).isPresent();
        if (!userCheck && request.getParameter("create") != null) {
            if (!userService.create(login, password, select)) {
                request.setAttribute("error", "This login is present");
                return false;
            }
        } else if (userCheck && request.getParameter("delete") != null) {
            if (!userService.delete(id)) {
                request.setAttribute("error", "This login is present");
                return false;
            }
        } else if (userCheck && request.getParameter("update") != null) {
            if(!userService.update(id, login, password, select)) {
                request.setAttribute("error", "This user was not found");
                return false;
            }
        }
        return true;
    }

    private Long getUserId(HttpServletRequest request) {
        return request.getParameter("id") != null
                ? Long.parseLong("0" + request.getParameter("id"))
                : 0L;
    }

    private void initServletContext() {
        ServletContext servletContext = getServletContext();
        if (servletContext.getAttribute("roles") == null) {
            servletContext.setAttribute("roles", Role.values());
        }
    }
}
