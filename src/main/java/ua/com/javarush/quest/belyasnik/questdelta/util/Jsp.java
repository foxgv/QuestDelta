package ua.com.javarush.quest.belyasnik.questdelta.util;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.UtilityClass;

import java.io.IOException;


@UtilityClass
public class Jsp {
    public void show(HttpServletRequest req, HttpServletResponse resp, String uri)
            throws ServletException, IOException {
        String path = "WEB-INF/views" + uri + ".jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    public void redirect(HttpServletRequest req, HttpServletResponse resp, String uri)
            throws IOException {
        resp.sendRedirect(req.getContextPath() + uri);
    }


}
