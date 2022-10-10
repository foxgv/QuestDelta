package ua.com.javarush.quest.belyasnik.questdelta.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.belyasnik.questdelta.entities.Answer;
import ua.com.javarush.quest.belyasnik.questdelta.entities.Question;
import ua.com.javarush.quest.belyasnik.questdelta.model.Model;
import ua.com.javarush.quest.belyasnik.questdelta.util.Go;
import ua.com.javarush.quest.belyasnik.questdelta.util.Jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Question3Servlet", value = "/question3")
public class Question3Servlet extends HttpServlet {
    Question question;
    ArrayList<Answer> answerArrayList = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        int id = 0;
        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id++))
                .text("Рассказать правду о себе.")
                .build());
        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id))
                .text("Солгать о себе.")
                .build());

        question = Question.builder()
                .title("Вопрос3")
                .fabula("Ты поднялся на мостик.")
                .text("Ты кто?")
                .loosMessage("Твою ложь разоблачили.")
                .viewAddress("WEB-INF/views/question3.jsp")
                .answers(answerArrayList)
                .answerPath(new String[]{Go.WIN, Go.LOOS})
                .build();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("question", question);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(question.getViewAddress());
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String answerText = request.getParameter("answer");
        int answer = Integer.parseInt(answerText);
        question.setSubmitAnswerIndex(Integer.parseInt(answerText));  // Запомнить полученный ответ в вопросе

        // Куда пойдём дальше?
        String url = question.getAnswerPath()[answer];
        request.setAttribute("url", url);
        Jsp.redirect(request, response, url);

    }
}
