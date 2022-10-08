package ru.javarush.quest.bogdanov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.quest.bogdanov.questdelta.entities.Game;
import ru.javarush.quest.bogdanov.questdelta.entities.GameState;
import ru.javarush.quest.bogdanov.questdelta.entities.Question;
import ru.javarush.quest.bogdanov.questdelta.services.AnswerService;
import ru.javarush.quest.bogdanov.questdelta.services.GameService;
import ru.javarush.quest.bogdanov.questdelta.services.QuestionService;

import java.io.IOException;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(GameServlet.class);

    private final GameService gameService = GameService.GAME_SERVICE;
    private final QuestionService questionService = QuestionService.QUESTION_SERVICE;
    private final AnswerService answerService = AnswerService.ANSWER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("game") == null) {
            init(request, session);
        }
        request.getRequestDispatcher("WEB-INF/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        long currentQuestionId = Long.parseLong(request.getParameter("currentquestionid"));
        long answerId = Long.parseLong(request.getParameter("answerid"));
        Question nextQuestionByAnswer = questionService.getNextQuestionByAnswer(currentQuestionId, answerId);
        Game game = (Game) session.getAttribute("game");
        if (nextQuestionByAnswer.answerList == null) {
            if (answerService.getAnswer(answerId).isCorrect()) {
                game.gameState = GameState.WIN;
            } else {
                game.gameState = GameState.LOSE;
            }
        } else {
            game.currentQuestionId = nextQuestionByAnswer.id;
        }
        gameService.update(game);
        session.setAttribute("question", nextQuestionByAnswer);
        request.getRequestDispatcher("WEB-INF/game.jsp").forward(request, response);
    }

    private void init(HttpServletRequest request, HttpSession session) {
        long questId = getQuestId(request);
        long currentUserId = (long) session.getAttribute("id");
        Game game = new Game(currentUserId, questId);
        log.info("game {} initialized, with {} quest, by user {}", game.id, questId, currentUserId);
        long firstQuestionId = questionService.firstQuestionId(questId);
        game.currentQuestionId = firstQuestionId;
        game.gameState = GameState.STARTED;
        gameService.create(game);
        Question question = questionService.getQuestionById(firstQuestionId);
        session.setAttribute("game", game);
        session.setAttribute("question", question);
    }

    private Long getQuestId(HttpServletRequest request) {
        return request.getParameter("questid") != null
                ? Long.parseLong("0" + request.getParameter("questid"))
                : 1L;
    }
}
