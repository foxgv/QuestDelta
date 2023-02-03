package com.javarush.khmelov.controller.user;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.service.UserService;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;


@WebServlet(value = Go.LOGIN, name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private final UserService userService = Winter.getBean(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsp.forward(req, resp, Go.LOGIN);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<UserDto> optionalUser = userService.find(FormData.of(req));
        if (optionalUser.isPresent()) {
            req.getSession().setAttribute(Jsp.Key.USER, optionalUser.get());
            Jsp.redirect(req, resp, Go.PROFILE);
        } else {
            Jsp.forward(req, resp, Go.LOGIN, "Нет такого пользователя");
        }
    }
}
