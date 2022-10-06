package ua.com.javarush.quest.kossatyy.questdelta.controller.website;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Role;
import ua.com.javarush.quest.kossatyy.questdelta.service.UserService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Optional;

import static java.util.Objects.isNull;
import static ua.com.javarush.quest.kossatyy.questdelta.utils.ErrorMessage.*;

@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsp.forward(req, resp, Jsp.SIGNUP);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(Attribute.LOGIN.getValue()); //TODO Duplicate code with LoginServlet
        boolean validLogin = userService.validateLogin(login);
        if (!validLogin) {
            req.setAttribute(Attribute.ERROR.getValue(), LOGIN_NOT_VALID);
            Jsp.forward(req, resp, Jsp.SIGNUP);
            return;
        }

        String password = req.getParameter(Attribute.PASSWORD.getValue()); //TODO Validate in filter log/pass with AuthService?
        boolean validPass = userService.validatePassword(password);
        if (!validPass) {
            req.setAttribute(Attribute.ERROR.getValue(), PASSWORD_NOT_VALID);
            Jsp.forward(req, resp, Jsp.SIGNUP);
            return;
        }

        Optional<UserDto> user = userService.findByLogin(login);
        if (user.isPresent()) {
            req.setAttribute(Attribute.ERROR.getValue(), LOGIN_ALREADY_USED);
            Jsp.forward(req, resp, Jsp.SIGNUP);
            return;
        }

        String roleParameter = req.getParameter(Attribute.ROLE.getValue());
        Role userRole = isNull(roleParameter)
                ? Role.GUEST
                : userService.getRole(roleParameter);

        userService.createUser(login, password, userRole);
        Optional<UserDto> userDtoFromDB = userService.findByCredentials(login, password);
        if (userDtoFromDB.isPresent()) {
            HttpSession session = req.getSession();
            UserDto userDto = userDtoFromDB.get();
            String userAttribute = Attribute.USER.getValue();
            if (isNull(session.getAttribute(userAttribute))) {
                session.setAttribute(userAttribute, userDto);
                session.setAttribute(Attribute.ROLE.getValue(), userDto.getRole());
            }
            Jsp.forward(req, resp, Jsp.MENU);
        } else {
            req.setAttribute(Attribute.ERROR.getValue(), USER_NOT_CREATED);
            Jsp.forward(req, resp, Jsp.SIGNUP);
        }
    }
}
