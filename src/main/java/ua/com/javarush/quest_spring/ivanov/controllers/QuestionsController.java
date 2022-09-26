package ua.com.javarush.quest_spring.ivanov.controllers;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.javarush.quest_spring.ivanov.entities.Question;
import ua.com.javarush.quest_spring.ivanov.entities.User;
import ua.com.javarush.quest_spring.ivanov.services.QuestionsService;
import ua.com.javarush.quest_spring.ivanov.utils.GameStatsHelper;
import ua.com.javarush.quest_spring.ivanov.utils.QuestionsHelper;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("tasks")
public class QuestionsController {
    private final QuestionsService service;
    private final GameStatsHelper statsHelper;
    private final QuestionsHelper questionsHelper;
    private final Environment env;
    private String action;


    public QuestionsController(QuestionsService service, GameStatsHelper statsHelper, QuestionsHelper questionsHelper, Environment env) {
        this.service = service;
        this.statsHelper = statsHelper;
        this.questionsHelper = questionsHelper;
        this.env = env;
    }

    @GetMapping("start")
    public String showQuestStart() {
        return "tasks-start-page";
    }

    @GetMapping("start-quiz")
    public String showQuestionQuiz(HttpServletRequest request, Model model) {
        service.fillQuestions(env.getProperty("pathToQuestionsQuiz"), env.getProperty("pathToAnswersQuiz"));
        action = "quiz";
        questionStarter(1, model);
        statsHelper.addGameStat(request, "gameCounter");
        statsHelper.setQuantityOfCorrectAnswers(request, "setTo0");
        return "question-page";
    }

    @GetMapping("start-quest")
    public String showQuestionQuest(HttpServletRequest request, Model model) {
        service.fillQuestions(env.getProperty("pathToQuestionsQuest"), env.getProperty("pathToAnswersQuest"));
        action = "quest";
        questionStarter(1, model);
        statsHelper.addGameStat(request, "gameCounter");
        return "question-page";
    }

    @PostMapping("{id}")
    public String showQuestionQuizById(@PathVariable int id,
                                       @RequestParam("chosenAnswer") String answer,
                                       HttpServletRequest request,
                                       Model model) {
        Question previousQuestion = service.getQuestionById(id - 1);
        String result = "question-page";
        questionStarter(id, model);
        result = questionsHelper.getQuestionResult(id, answer, statsHelper, request, previousQuestion, action, result);
        return result;
    }


    @GetMapping("fail")
    public String showFailPage(HttpServletRequest request) {
        statsHelper.addGameStat(request, "failed");
        return "fail-page";
    }

    @GetMapping("happy-end")
    public String showHappyEndingPage(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("counter", user.getGame().getQuantityQuizCorrectAnswers());
        model.addAttribute("action", action);
        statsHelper.addGameStat(request, "completed");
        return "happy-ending-page";
    }

    private void questionStarter(int id, Model model) {
        Question question = service.getQuestionById(id);
        model.addAttribute("question", question);
        model.addAttribute("nextQuestionNumber", id + 1);
    }

}
