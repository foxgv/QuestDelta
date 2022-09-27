package ua.com.javarush.quest.kossatyy.questdelta.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.service.UserService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;

import java.io.IOException;
import java.util.Optional;

import static java.util.Objects.isNull;
import static ua.com.javarush.quest.kossatyy.questdelta.utils.ErrorMessage.*;

@WebServlet(name = "DeleteServlet", value = "/accounts/delete")
public class DeleteServlet extends HttpServlet {

    private final UserService userService = UserService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        if (isNull(login)) {
            req.setAttribute(Attribute.ERROR.getValue(), USER_NOT_FOUND);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/accounts");
            requestDispatcher.forward(req,resp);
            return;
        }

        UserDto currentUser = (UserDto) req.getSession().getAttribute(Attribute.USER.getValue());
        String userLogin = currentUser.getLogin();
        if (login.equals(userLogin)) {
            req.setAttribute(Attribute.ERROR.getValue(), DELETE_YOURSELF);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/accounts");
            requestDispatcher.forward(req,resp);
            return;
        }

        Optional<UserDto> user = userService.findByLogin(login);
        user.ifPresent(userDto -> userService.deleteById(userDto.getId()));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/accounts");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
