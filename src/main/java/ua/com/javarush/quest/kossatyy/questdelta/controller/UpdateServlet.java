package ua.com.javarush.quest.kossatyy.questdelta.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Role;
import ua.com.javarush.quest.kossatyy.questdelta.service.UserService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Optional;

import static java.util.Objects.nonNull;
import static ua.com.javarush.quest.kossatyy.questdelta.utils.ErrorMessage.*;

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {

    private final UserService userService = UserService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(Attribute.LOGIN.getValue()); //TODO Duplicate code with Login/Signup Servlet
        Optional<UserDto> user = userService.findByLogin(login);

        if (user.isEmpty()) {
            req.setAttribute(Attribute.ERROR.getValue(), USER_NOT_FOUND);
            Jsp.forward(req, resp, Jsp.UPDATE);
            return;
        } else {
            UserDto userDto = user.get();
            req.setAttribute(Attribute.USER_UPDATE.getValue(), userDto);
        }

        Jsp.forward(req, resp, Jsp.UPDATE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginNew = req.getParameter(Attribute.LOGIN_NEW.getValue()); //TODO Duplicate code with Login/Signup Servlet
        if (nonNull(loginNew) && !loginNew.isBlank()) {
            boolean validLogin = userService.validateLogin(loginNew);
            if (!validLogin) {
                req.setAttribute(Attribute.ERROR.getValue(), LOGIN_NOT_VALID);
                Jsp.forward(req, resp, Jsp.UPDATE);
                return;
            }
        }

        String password = req.getParameter(Attribute.PASSWORD.getValue()); //TODO Validate in filter log/pass with AuthService?

        if (nonNull(password) && !password.isBlank()) {
            boolean validPass = userService.validatePassword(password);
            if (!validPass) {
                req.setAttribute(Attribute.ERROR.getValue(), PASSWORD_NOT_VALID);
                Jsp.forward(req, resp, Jsp.UPDATE);
                return;
            }
        }

        Optional<UserDto> userCheck = userService.findByLogin(loginNew);
        if (userCheck.isPresent()) {
            req.setAttribute(Attribute.ERROR.getValue(), LOGIN_ALREADY_USED);
            Jsp.forward(req, resp, Jsp.UPDATE);
            return;
        }

        String roleParameter = req.getParameter(Attribute.ROLE.getValue());
        Role userRole = userService.getRole(roleParameter);

        String idParam =  req.getParameter(Attribute.ID.getValue());
        long id = idParam != null && !idParam.isBlank()
                ? Long.parseLong(idParam)
                : 0L;

        Optional<UserDto> userFromDB = userService.findById(id);

        if (userFromDB.isPresent()) {
            Long idUser = userFromDB.get().getId();
            userService.update(idUser, loginNew, password, userRole);
        } else {
            req.setAttribute(Attribute.ERROR.getValue(), USER_NOT_FOUND);
            Jsp.forward(req, resp, Jsp.UPDATE);
            return;
        }

        resp.sendRedirect("/accounts");
    }
}
