package ru.javarush.volokitin.questdelta.util;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.UtilityClass;

import java.io.IOException;

@UtilityClass
public class JSP {

    public void forward(HttpServletRequest req, HttpServletResponse resp, String dest) throws ServletException, IOException {
        String path = String.format("WEB-INF/%s.jsp", dest);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    public void redirect(HttpServletRequest req, HttpServletResponse resp, String dest) throws IOException {
        String path = String.format("%s/%s", req.getContextPath(), dest);
        resp.sendRedirect(path);
    }
}
