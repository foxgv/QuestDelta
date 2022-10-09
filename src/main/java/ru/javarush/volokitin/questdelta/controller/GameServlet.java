package ru.javarush.volokitin.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarush.volokitin.questdelta.dto.QuestionDTO;
import ru.javarush.volokitin.questdelta.service.GameService;
import ru.javarush.volokitin.questdelta.util.Common;
import ru.javarush.volokitin.questdelta.util.JSP;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private final GameService gameService = GameService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long curQuestionID = (Long) Optional
                .ofNullable(req
                        .getSession()
                        .getAttribute("curQuestionID"))
                .orElse(0L);
        QuestionDTO questionDTO = gameService.getQuestion(curQuestionID);
        setRequestAttributes(req, curQuestionID, questionDTO);

        JSP.forward(req, resp, "game");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<String> answer = Common.getRequestParameter(req, "answer");

        if (answer.isPresent()) {
            long answerID = Long.parseLong(answer.get());
            HashMap<String, Object> gameServiceResponse = gameService.checkAnswer(answerID);

            if ((boolean) gameServiceResponse.get("answerIsCorrect")) {
                incrementCorrectAnswersCount(req);
            }

            Optional<Long> nextQuestionIDOptional = (Optional<Long>) gameServiceResponse.get("nextQuestionID");
            if (nextQuestionIDOptional.isPresent()) {
                Long nextQuestionID = nextQuestionIDOptional.get();
                req.getSession().setAttribute("curQuestionID", nextQuestionID);

                JSP.redirect(req, resp, "game");
            } else {
                gameService.saveGameStatistics(
                        Common.getSessionAttribute(req, "user"),
                        Integer.parseInt(Common.getSessionAttribute(req, "correctAnswersCount"))
                );

                JSP.redirect(req, resp, "game_over");
            }
        } else {
            JSP.redirect(req, resp, "game");
        }
    }

    private static void setRequestAttributes(HttpServletRequest req, Long curQuestionID, QuestionDTO questionDTO) {
        req.setAttribute("question", questionDTO);
        req.getSession().setAttribute("curQuestionID", curQuestionID);
    }

    private void incrementCorrectAnswersCount(HttpServletRequest req) {
        int correctAnswersCount = (int) Optional
                .ofNullable(req
                        .getSession()
                        .getAttribute("correctAnswersCount"))
                .orElse(0);
        req.getSession().setAttribute("correctAnswersCount", ++correctAnswersCount);
    }
}
