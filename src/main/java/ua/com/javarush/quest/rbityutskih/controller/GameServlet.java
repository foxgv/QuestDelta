package ua.com.javarush.quest.rbityutskih.controller;
import ua.com.javarush.quest.rbityutskih.entity.*;


import ua.com.javarush.quest.rbityutskih.service.*;

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
        Long currentQuestionId = gameService.get((Long)req.getSession().getAttribute("id")).getCurrentQuestionId();
        if(req.getParameter("answer") != null){
            if(req.getParameter("answer").equals("0")){
                Answer answer = questionService.get(currentQuestionId).getAnswers().stream().toList().get(0);
                req.getSession().setAttribute("correct", answer.getCorrect());
                currentQuestionId = answer.getNextQuestionId();

            }
            else {
                Answer answer = questionService.get(currentQuestionId).getAnswers().stream().toList().get(1);
                req.getSession().setAttribute("correct", answer.getCorrect());
                currentQuestionId = answer.getNextQuestionId();
            }
            gameService.get((Long)req.getSession().getAttribute("id")).setCurrentQuestionId(currentQuestionId);

        }


        go(req,resp, currentQuestionId);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("game.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void go(HttpServletRequest req, HttpServletResponse resp, long currentQuestionId) throws ServletException, IOException {
        req.setAttribute("questionText", questionService.get(currentQuestionId).getText());

        Collection<Answer> answers = questionService.get(currentQuestionId).getAnswers();
        Game game = gameService.get((Long)req.getSession().getAttribute("id"));

        if(answers==null){
            if(req.getSession().getAttribute("correct")==null){
                game.setState(GameState.WIN);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("win.jsp");
                requestDispatcher.forward(req, resp);
            }
            else{
                game.setState(GameState.LOSE);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("lose.jsp");
                requestDispatcher.forward(req, resp);
            }
        }

        req.setAttribute("ans1", answers.stream().toList().get(0).getText());
        req.setAttribute("ans2", answers.stream().toList().get(1).getText());
    }
}