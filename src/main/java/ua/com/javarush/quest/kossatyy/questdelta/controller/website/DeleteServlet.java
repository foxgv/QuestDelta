package ua.com.javarush.quest.kossatyy.questdelta.controller.website;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.service.UserService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;

import java.io.IOException;
import java.util.Optional;

import static java.util.Objects.isNull;
import static ua.com.javarush.quest.kossatyy.questdelta.utils.ErrorMessage.DELETE_YOURSELF;
import static ua.com.javarush.quest.kossatyy.questdelta.utils.ErrorMessage.USER_NOT_FOUND;

@WebServlet(name = "DeleteServlet", value = "/accounts/delete")
public class DeleteServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(Attribute.LOGIN.getValue());
        if (isNull(login)) {
            req.setAttribute(Attribute.ERROR.getValue(), USER_NOT_FOUND);
            req.getRequestDispatcher("/accounts").forward(req, resp);
            return;
        }

        UserDto currentUser = (UserDto) req.getSession().getAttribute(Attribute.USER.getValue());
        String userLogin = currentUser.getLogin();
        if (login.equals(userLogin)) {
            req.setAttribute(Attribute.ERROR.getValue(), DELETE_YOURSELF);
            req.getRequestDispatcher("/accounts").forward(req, resp);
            return;
        }

        Optional<UserDto> user = userService.findByLogin(login);
        user.ifPresent(userDto -> userService.deleteById(userDto.getId()));
        req.getRequestDispatcher("/accounts").forward(req, resp);
    }
}
