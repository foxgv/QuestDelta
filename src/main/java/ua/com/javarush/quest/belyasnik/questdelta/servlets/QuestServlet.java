package ua.com.javarush.quest.belyasnik.questdelta.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.belyasnik.questdelta.util.Go;
import ua.com.javarush.quest.belyasnik.questdelta.util.Jsp;

import java.io.IOException;

//@WebServlet(name = "QuestServlet", value = Go.ROOT)
@WebServlet(name = "QuestServlet", value = Go.QUEST)
public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); // получить номер сессии
        Jsp.show(request, response, "/quest");
    }
}
