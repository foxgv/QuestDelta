package ua.com.javarush.quest.kossatyy.questdelta.utils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.UtilityClass;

import java.io.IOException;

@UtilityClass
public class Jsp {

    private final String PATH_TO_JSP = "/WEB-INF/jsp/";
    public final String MENU = "menu.jsp";
    public final String LOGIN = "login.jsp";
    public final String SIGNUP = "signup.jsp";
    public final String ACCOUNTS = "accounts.jsp";
    public final String PROFILE = "profile.jsp";
    public final String UPDATE = "update.jsp";

    public void forward(HttpServletRequest request, HttpServletResponse response, String filename) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH_TO_JSP + filename);
        requestDispatcher.forward(request, response);
    }
}
