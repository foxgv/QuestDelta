package com.javarush.khmelov.controller.user;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.service.UserService;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {Go.USERS},name = "UsersServlet")
public class UsersServlet extends HttpServlet {

    private final UserService userService = Winter.getBean(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(Jsp.Key.USERS, userService.getAll());
        Jsp.forward(req, resp, Go.USERS);
    }
}
