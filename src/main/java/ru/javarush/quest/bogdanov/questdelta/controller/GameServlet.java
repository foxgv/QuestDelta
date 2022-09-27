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
import ru.javarush.quest.bogdanov.questdelta.entities.Quest;
import ru.javarush.quest.bogdanov.questdelta.entities.Question;
import ru.javarush.quest.bogdanov.questdelta.services.AnswerService;
import ru.javarush.quest.bogdanov.questdelta.services.GameService;
import ru.javarush.quest.bogdanov.questdelta.services.QuestService;
import ru.javarush.quest.bogdanov.questdelta.services.QuestionService;

import java.io.IOException;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger();

    private final GameService gameService = GameService.GAME_SERVICE;
    private final QuestService questService = QuestService.QUEST_SERVICE;
    private final QuestionService questionService = QuestionService.QUESTION_SERVICE;
    private final AnswerService answerService = AnswerService.ANSWER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = new Game(1L, 1L);
        Quest quest = questService.getQuest(1L);
        game.currentQuestionId = 1L;
        game.gameState = GameState.STARTED;
        Question question = questionService.getQuestion(1L);
        System.out.println(question.text);
        HttpSession session = request.getSession();
        session.setAttribute("question", question);
        session.setAttribute("quest", quest);
        request.getRequestDispatcher("WEB-INF/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
