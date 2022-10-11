package ua.com.javarush.quest.zazimko.questdelta.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.zazimko.questdelta.entity.Answer;
import ua.com.javarush.quest.zazimko.questdelta.entity.Question;
import ua.com.javarush.quest.zazimko.questdelta.repository.QuestionsRepository;
import ua.com.javarush.quest.zazimko.questdelta.repository.UserRepository;
import ua.com.javarush.quest.zazimko.questdelta.util.Jsp;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {

    UserRepository userRepository= UserRepository.getUserRepository();
    QuestionsRepository questionsRepository=QuestionsRepository.getQuestionsRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Question, List<Answer>> questionsMap = questionsRepository.getQuestionsMap();
        Set<Map.Entry<Question, List<Answer>>> questionAndAnswers = questionsMap.entrySet();
        for (Map.Entry<Question, List<Answer>> questionAndAnswer : questionAndAnswers) {
            Question question = questionAndAnswer.getKey();
        }
        request.setAttribute("question",questionsMap);
        Jsp.forward(request, response, "game");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
