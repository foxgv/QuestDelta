package ua.com.javarush.quest.zazimko.questdelta.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.zazimko.questdelta.entity.Answer;
import ua.com.javarush.quest.zazimko.questdelta.entity.Question;
import ua.com.javarush.quest.zazimko.questdelta.repository.AnswerRepository;
import ua.com.javarush.quest.zazimko.questdelta.repository.QuestionsRepository;
import ua.com.javarush.quest.zazimko.questdelta.repository.UserRepository;
import ua.com.javarush.quest.zazimko.questdelta.util.Jsp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static ua.com.javarush.quest.zazimko.questdelta.repository.AnswerRepository.getAnswerRepository;

@WebServlet(name = "GameServlet", value = "/game")
public class QuestionOne extends HttpServlet {

   int currentQuestionId=0;
    private static final AnswerRepository answerRepository= getAnswerRepository();
    QuestionsRepository questionsRepository=QuestionsRepository.getQuestionsRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(currentQuestionId==0) {
            Question question = questionsRepository.getQuestionList().get(currentQuestionId);
            request.setAttribute("question", question);
            Jsp.forward(request, response, "game");
        }else {
            Question question = questionsRepository.findQuestion((long) currentQuestionId);
            request.setAttribute("question", question);
            Jsp.forward(request, response, "game");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answerText = request.getParameter("answer");
        Long answer = Long.parseLong(answerText);
        Answer answer1 = answerRepository.find(answer);
        int nextQuestionId = Math.toIntExact(answer1.getNextQuestionId());
        currentQuestionId=nextQuestionId;

        Jsp.redirect(request, response, "game");
    }
}
