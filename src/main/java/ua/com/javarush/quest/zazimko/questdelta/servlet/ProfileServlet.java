package ua.com.javarush.quest.zazimko.questdelta.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.zazimko.questdelta.entity.User;
import ua.com.javarush.quest.zazimko.questdelta.repository.UserRepository;
import ua.com.javarush.quest.zazimko.questdelta.util.Jsp;
import ua.com.javarush.quest.zazimko.questdelta.util.UserRole;
import ua.com.javarush.quest.zazimko.questdelta.util.UserService;

import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    private final UserService userService = UserService.INSTANCE;
    UserRepository userRepository = UserRepository.getUserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        long id = (long) session.getAttribute("UserId");
        User user = userRepository.getUser(id);
        request.setAttribute("user", user);
        Jsp.forward(request, response, "profile");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("start") != null) {
            Jsp.forward(request,response, "game");
        } else if (request.getParameter("logout") != null) {
            Jsp.forward(request,response, "logout");
        } else {
            throw new UnsupportedOperationException("not found command");
        }
    }

 }
