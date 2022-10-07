package ua.com.javarush.quest.belyasnik.questdelta.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.belyasnik.questdelta.model.Model;
import ua.com.javarush.quest.belyasnik.questdelta.util.Go;
import ua.com.javarush.quest.belyasnik.questdelta.util.Jsp;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "statListServlet", value = Go.STATISTIC)
public class StatisticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<String> statistics = model.list();
        request.setAttribute("title", Go.statisticTitle);
        request.setAttribute("statistics", statistics);
        Jsp.show(request, response, Go.STATISTIC);
    }
}