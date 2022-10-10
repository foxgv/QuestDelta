package ua.com.javarush.quest.belyasnik.questdelta.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.belyasnik.questdelta.util.Go;
import ua.com.javarush.quest.belyasnik.questdelta.util.Jsp;

import java.io.IOException;

@WebServlet(name = "MainServlet", value = {Go.ROOT, Go.MAIN})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", Go.mainTitle);
        Jsp.show(request, response, Go.MAIN);
    }
}
