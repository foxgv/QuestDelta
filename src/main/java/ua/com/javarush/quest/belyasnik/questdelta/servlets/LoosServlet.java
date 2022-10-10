package ua.com.javarush.quest.belyasnik.questdelta.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.belyasnik.questdelta.entities.Question;
import ua.com.javarush.quest.belyasnik.questdelta.entities.Statistic;
import ua.com.javarush.quest.belyasnik.questdelta.model.Model;
import ua.com.javarush.quest.belyasnik.questdelta.util.Go;
import ua.com.javarush.quest.belyasnik.questdelta.util.Jsp;

import java.io.IOException;
import java.util.Date;


@WebServlet(name = "LoosServlet", value = "/loos")
public class LoosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = Model.getInstance();
        Question question = (Question) request.getAttribute("question");
        //Statistic statistic = (Statistic) request.getSession().getAttribute("statistic");
        Statistic statistic = Statistic.builder()
                .dateTime(Statistic.currentTime( new Date(System.currentTimeMillis())))
                .lastQuestion(question)
                .result("Проигрыш")
                .build();

        model.add(statistic);

        Jsp.show(request, response, Go.LOOS);
    }
}
