package com.javarush.quest.bulimov.questdelta.controller;

import com.javarush.quest.bulimov.questdelta.dto.AnswerDto;
import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.services.GameService;
import com.javarush.quest.bulimov.questdelta.services.QuestionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "gameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private final GameService gameService = GameService.INSTANCE;
    private final QuestionService questionService = QuestionService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long currentQuestionId = gameService.find(FormData.of(req)).get().getCurrentQuestionId();
        if(req.getParameter("answer1") != null || req.getParameter("answer2")!= null ){
            currentQuestionId = req.getAttribute("answer1") != null ?
                    questionService.get(currentQuestionId).get().getAnswers().stream().toList().get(0).getNextQuestionId()
                    : questionService.get(currentQuestionId).get().getAnswers().stream().toList().get(1).getNextQuestionId();


        }

        go(req, currentQuestionId);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("game.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void go(HttpServletRequest req, long currentQuestionId){
        req.setAttribute("questionText", questionService.get(currentQuestionId).get().getText());

        Collection<AnswerDto> answers = questionService.get(currentQuestionId).get().getAnswers();

        req.setAttribute("ans1", answers.stream().toList().get(0).getText());
        req.setAttribute("ans2", answers.stream().toList().get(1).getText());
    }
}