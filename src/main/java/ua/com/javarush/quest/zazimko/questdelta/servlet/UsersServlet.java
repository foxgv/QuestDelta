package ua.com.javarush.quest.zazimko.questdelta.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.zazimko.questdelta.entity.User;
import ua.com.javarush.quest.zazimko.questdelta.repository.UserRepository;
import ua.com.javarush.quest.zazimko.questdelta.util.Jsp;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "UsersServlet", value = "/users")
public class UsersServlet extends HttpServlet {
    UserRepository userRepository= UserRepository.getUserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<User> users = userRepository.getUsers().values();
        request.setAttribute("users", users);
        Jsp.forward(request, response, "users");
    }

}
