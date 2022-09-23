package ua.com.javarush.quest.ryabov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.ryabov.questdelta.entity.Answer;
import ua.com.javarush.quest.ryabov.questdelta.entity.Question;
import ua.com.javarush.quest.ryabov.questdelta.repository.Repository;
import ua.com.javarush.quest.ryabov.questdelta.repository.RepositoryLoader;
import ua.com.javarush.quest.ryabov.questdelta.util.Jsp;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
    Repository<Question> questionRepository = RepositoryLoader.questionRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO НАДО ПРОЙТИСЬ ПО СЕССИИ И УЗНАТЬ ПОСЛЕДНИЙ ВОПРОС В ТЕСТЕ
        String question = questionRepository.get(3).get().getQuestion();
        List<Answer> answers = questionRepository.get(3).get().getAnswers();
        req.setAttribute("question", question);
        req.setAttribute("answers", answers);
        Jsp.forward(req, resp, "question");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextQuestionID = req.getParameter("nextQuestionID");
        if (nextQuestionID != null){
            long id = Long.parseLong(nextQuestionID);
            Optional<Question> question = questionRepository.get(id);
            String text = question.get().getQuestion();
            List<Answer> answers = question.get().getAnswers();
            req.setAttribute("question", text);
            req.setAttribute("answers", answers);
        }
        Jsp.forward(req, resp, "question");
    }
}
