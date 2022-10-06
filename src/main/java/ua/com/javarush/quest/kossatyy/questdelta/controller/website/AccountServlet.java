package ua.com.javarush.quest.kossatyy.questdelta.controller.website;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.service.UserService;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Collection;

import static java.util.Objects.isNull;

@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_PAGE_NUMBER = 0;
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNumber = request.getParameter(Attribute.PAGE_NUMBER.getValue());
        int pageNumberValue;
        if(isNull(pageNumber)){
            pageNumberValue = DEFAULT_PAGE_NUMBER;
        } else {
            try {
                pageNumberValue = Integer.parseInt(pageNumber);
            } catch (NumberFormatException e) {
                pageNumberValue = DEFAULT_PAGE_NUMBER;
            }
        }
        request.setAttribute(Attribute.PAGE_NUMBER.getValue(), pageNumberValue);

        Collection<UserDto> users = userService.getAll(pageNumberValue, DEFAULT_PAGE_SIZE);
        request.setAttribute(Attribute.USERS.getValue(), users);

        int pages = userService.getAllCount() / DEFAULT_PAGE_SIZE;
        request.setAttribute(Attribute.PAGE_COUNT.getValue(), pages);

        Jsp.forward(request, response, Jsp.ACCOUNTS);
    }
}
