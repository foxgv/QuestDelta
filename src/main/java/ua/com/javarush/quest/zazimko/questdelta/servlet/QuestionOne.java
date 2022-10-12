package ua.com.javarush.quest.zazimko.questdelta.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.zazimko.questdelta.entity.Answer;
import ua.com.javarush.quest.zazimko.questdelta.entity.Question;
import ua.com.javarush.quest.zazimko.questdelta.repository.AnswerRepository;
import ua.com.javarush.quest.zazimko.questdelta.repository.QuestionsRepository;
import ua.com.javarush.quest.zazimko.questdelta.util.Jsp;

import java.io.IOException;

import static ua.com.javarush.quest.zazimko.questdelta.repository.AnswerRepository.getAnswerRepository;

@WebServlet(name = "GameServlet", value = "/game")
public class QuestionOne extends HttpServlet {

    int currentQuestionId = 0;
    private static final AnswerRepository answerRepository = getAnswerRepository();
    QuestionsRepository questionsRepository = QuestionsRepository.getQuestionsRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (currentQuestionId == 0) {
            Question question = questionsRepository.getQuestionList().get(currentQuestionId);
            request.setAttribute("question", question);
            Jsp.forward(request, response, "game");
        } else {
            Question question = questionsRepository.findQuestion((long) currentQuestionId);
            request.setAttribute("question", question);
            Jsp.forward(request, response, "game");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ((request.getParameter("answer") != null)) {
            String answerText = request.getParameter("answer");
            long answer = Long.parseLong(answerText);
            if(answer!=100) {
                Answer answer1 = answerRepository.find(answer);
                currentQuestionId = Math.toIntExact(answer1.getNextQuestionId());
                Jsp.redirect(request, response, "game");
            }else{
                currentQuestionId=0;
                Jsp.redirect(request, response, "logout");
            }
        }else {
            currentQuestionId=0;
            Jsp.redirect(request, response, "logout");
        }
    }
}
