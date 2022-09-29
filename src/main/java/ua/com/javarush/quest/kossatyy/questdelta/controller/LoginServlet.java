package ua.com.javarush.quest.kossatyy.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.service.UserService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Optional;

import static ua.com.javarush.quest.kossatyy.questdelta.utils.ErrorMessage.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsp.forward(req, resp, Jsp.LOGIN);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(Attribute.LOGIN.getValue()); //TODO Duplicate code with SignupServlet
        boolean validLogin = userService.validateLogin(login);
        if (!validLogin) {
            req.setAttribute(Attribute.ERROR.getValue(), LOGIN_NOT_VALID);
            Jsp.forward(req, resp, Jsp.LOGIN);
        }

        String password = req.getParameter(Attribute.PASSWORD.getValue()); //TODO Validate in filter log/pass with AuthService?
        boolean validPass = userService.validatePassword(password);
        if (!validPass) {
            req.setAttribute(Attribute.ERROR.getValue(), PASSWORD_NOT_VALID);
            Jsp.forward(req, resp, Jsp.LOGIN);
        }

        Optional<UserDto> user = userService.findByLogin(login);

        if (user.isPresent()) {
            Optional<UserDto> userDtoFromDB = userService.findByCredentials(login,password);

            if (userDtoFromDB.isPresent()) {
                HttpSession session = req.getSession();
                UserDto userDto = userDtoFromDB.get();
                session.setAttribute(Attribute.USER.getValue(), userDto);
                session.setAttribute(Attribute.ROLE.getValue(), userDto.getRole());
                Jsp.forward(req, resp, Jsp.MENU);
            } else {
                req.setAttribute(Attribute.ERROR.getValue(), WRONG_PASSWORD);
                Jsp.forward(req, resp, Jsp.LOGIN);
            }
        } else {
            req.setAttribute(Attribute.ERROR.getValue(), USER_NOT_FOUND);
            Jsp.forward(req, resp, Jsp.LOGIN);
        }
    }
}
