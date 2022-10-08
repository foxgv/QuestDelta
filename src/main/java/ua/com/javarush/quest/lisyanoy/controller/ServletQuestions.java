package ua.com.javarush.quest.lisyanoy.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.lisyanoy.service.QuestionService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletQuestions", value = "/ServletQuestions")
public class ServletQuestions extends HttpServlet {

    QuestionService questionService = QuestionService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int answer = Integer.parseInt(request.getParameter("answer"));
        Integer actualQuestion = answer / 10 - 1;
        int actualAnswer = answer % 10;

        questionService.createMapQuestionAnswers();
        Map<Integer, List<String>> questionAnswers = questionService.mapQuestionAnswers;
        List<String> listAnswer = questionAnswers.get(actualQuestion);

        switch (actualQuestion) {
            case 0 -> forwardResponse(request, listAnswer, actualAnswer, "/question1.jsp", response);
            case 1 -> forwardResponse(request, listAnswer, actualAnswer, "/question2.jsp", response);
            case 2 -> forwardResponse(request, listAnswer, actualAnswer, "/question3.jsp", response);
        }
    }

    private static void forwardResponse(HttpServletRequest request, List<String> listAnswer, int actualAnswer, String jsp, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("answerString", listAnswer.get(actualAnswer));
        request.setAttribute("answerNumber", actualAnswer);
        request.getRequestDispatcher(jsp).forward(request, response);
    }

}
