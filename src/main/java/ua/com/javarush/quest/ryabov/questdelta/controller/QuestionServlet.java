package ua.com.javarush.quest.ryabov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.ryabov.questdelta.entity.Answer;
import ua.com.javarush.quest.ryabov.questdelta.entity.Question;
import ua.com.javarush.quest.ryabov.questdelta.service.QuestionService;
import ua.com.javarush.quest.ryabov.questdelta.util.Jsp;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
    private final QuestionService questionService = QuestionService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO НАДО ПРОЙТИСЬ ПО СЕССИИ И УЗНАТЬ ПОСЛЕДНИЙ ВОПРОС В ТЕСТЕ
        String question = null;
        List<Answer> answers = null;
        HttpSession session = req.getSession();
        Optional<Question> lastQuestion = (Optional<Question>) session.getAttribute("lastQuestion");
        if (lastQuestion == null){
            question = questionService.get(2).get().getQuestion();
            answers = questionService.get(2).get().getAnswers();
        }else {
                question = lastQuestion.get().getQuestion();
                answers =  lastQuestion.get().getAnswers();
        }
        req.setAttribute("question", question);
        req.setAttribute("answers", answers);
        Jsp.forward(req, resp, "question");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextQuestionID = req.getParameter("nextQuestionID");
        HttpSession session = req.getSession();
        if (nextQuestionID != null){
            long id = Long.parseLong(nextQuestionID);
            Optional<Question> question = questionService.get(id);
            String text = question.get().getQuestion();
            List<Answer> answers = question.get().getAnswers();
            req.setAttribute("question", text);
            req.setAttribute("answers", answers);
            session.setAttribute("lastQuestion", question);
        }
        Jsp.forward(req, resp, "question");
    }
}
