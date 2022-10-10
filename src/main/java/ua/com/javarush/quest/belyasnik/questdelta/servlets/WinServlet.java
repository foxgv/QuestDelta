package ua.com.javarush.quest.belyasnik.questdelta.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.belyasnik.questdelta.entities.Question;
import ua.com.javarush.quest.belyasnik.questdelta.entities.Statistic;
import ua.com.javarush.quest.belyasnik.questdelta.model.Model;
import ua.com.javarush.quest.belyasnik.questdelta.util.Go;
import ua.com.javarush.quest.belyasnik.questdelta.util.Jsp;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "WinServlet", value = "/win")
public class WinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = Model.getInstance();
        Question question = (Question) request.getAttribute("question");
        //Statistic statistic = (Statistic) request.getSession().getAttribute("statistic");
        Statistic statistic = Statistic.builder()
                .dateTime(Statistic.currentTime( new Date(System.currentTimeMillis())))
                .lastQuestion(question)
                .result("Выигрыш")
                .build();

        model.add(statistic);

        Jsp.show(request, response, Go.WIN);
    }
}
