package ua.com.javarush.quest_spring.ivanov.controllers;

import ua.com.javarush.quest_spring.ivanov.entities.Question;
import ua.com.javarush.quest_spring.ivanov.services.QuestionsService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("tasks")
public class QuestionsController {
    private final QuestionsService service;

    private final Environment env;

    private String action;

    private int counter;

    public QuestionsController(QuestionsService service, Environment env) {
        this.service = service;
        this.env = env;
    }

    @GetMapping("start")
    public String showQuestStart() {
        return "tasks-start-page";
    }

    @GetMapping("start-quiz")
    public String showQuestionQuiz(Model model) {
        service.fillQuestions(env.getProperty("pathToQuestionsQuiz"), env.getProperty("pathToAnswersQuiz"));
        action = "quiz";
        counter = 0;
        questionStarter(1, model);
        return "question-page";
    }

    @GetMapping("start-quest")
    public String showQuestionQuest(Model model) {
        service.fillQuestions(env.getProperty("pathToQuestionsQuest"), env.getProperty("pathToAnswersQuest"));
        action = "quest";
        questionStarter(1, model);
        return "question-page";
    }

    @PostMapping("{id}")
    public String showQuestionQuizById(@PathVariable int id, @RequestParam("chosenAnswer") String answer, Model model) {
        Question previousQuestion = service.getQuestionById(id - 1);
        questionStarter(id, model);
        if (id == service.getQuestions().size() + 1) {
            if (previousQuestion.getCorrectAnswer().getText().equals(answer)) {
                counter = counter + 1;
            }
            return "redirect:/tasks/happy-end";
        }

        if (action.equals("quiz")) {
            if (previousQuestion.getCorrectAnswer().getText().equals(answer)) {
                counter = counter + 1;
                return "question-page";
            }
        }
        if (action.equals("quest")) {
            if (previousQuestion.getCorrectAnswer().getText().equals(answer)) {
                return "question-page";
            } else {
                return "redirect:/tasks/fail";
            }
        }
        return "question-page";
    }

    @GetMapping("fail")
    public String showFailPage() {
        return "fail-page";
    }

    @GetMapping("happy-end")
    public String showHappyEndingPage(Model model) {
        model.addAttribute("counter", counter);
        model.addAttribute("action", action);
        return "happy-ending-page";
    }

    private void questionStarter(int id, Model model) {
        Question question = service.getQuestionById(id);
        model.addAttribute("question", question);
        model.addAttribute("nextQuestionNumber", id + 1);
    }
}
