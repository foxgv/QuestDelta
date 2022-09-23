package ua.com.javarush.quest.kossatyy.questdelta.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.User;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.Mapper;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.UserMapper;
import ua.com.javarush.quest.kossatyy.questdelta.service.UserService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Optional;

import static ua.com.javarush.quest.kossatyy.questdelta.utils.ErrorMessage.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.INSTANCE;
    private final Mapper<UserDto, User> userMapper = new UserMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsp.forward(req, resp, Jsp.LOGIN);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login"); //TODO Duplicate code with SignupServlet
        boolean validLogin = userService.validateLogin(login);
        if (!validLogin) {
            req.setAttribute(Attribute.ERROR.getName(), LOGIN_NOT_VALID);
            Jsp.forward(req, resp, Jsp.LOGIN);
        }

        String password = req.getParameter("password"); //TODO Validate in filter log/pass with AuthService?
        boolean validPass = userService.validatePassword(password);
        if (!validPass) {
            req.setAttribute(Attribute.ERROR.getName(), PASSWORD_NOT_VALID);
            Jsp.forward(req, resp, Jsp.LOGIN);
        }

        Optional<UserDto> user = userService.findByLogin(login);

        if (user.isPresent()) {
            Optional<UserDto> userFromDB = userService.findByCredentials(login,password);

            if (userFromDB.isPresent()) {
                UserDto userDto = userFromDB.get();
                HttpSession session = req.getSession();
                session.setAttribute(Attribute.USER.getName(), userDto);
                Jsp.forward(req, resp, Jsp.MENU);
            } else {
                req.setAttribute(Attribute.ERROR.getName(), WRONG_PASSWORD);
                Jsp.forward(req, resp, Jsp.LOGIN);
            }
        } else {
            req.setAttribute(Attribute.ERROR.getName(), USER_NOT_FOUND);
            Jsp.forward(req, resp, Jsp.LOGIN);
        }
    }
}
