package ua.com.javarush.quest_spring.ivanov.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import ua.com.javarush.quest_spring.ivanov.entities.Game;
import ua.com.javarush.quest_spring.ivanov.entities.Question;
import ua.com.javarush.quest_spring.ivanov.entities.User;
import ua.com.javarush.quest_spring.ivanov.services.QuestionsService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuestionsHelperTest {

    @Autowired
    private QuestionsService service;
    @Autowired
    private GameStatsHelper statsHelper;
    @Autowired
    private QuestionsHelper questionsHelper;
    @Autowired
    private Environment env;
    private MockHttpServletRequest request = new MockHttpServletRequest();


    @BeforeEach
    void setup() {
        User user = new User(1
                , new Game(1, 2, 3, 0)
                , "username"
                , "pass"
                , "email");
        request.getSession().setAttribute("user", user);
    }

    @Test
    void getQuestionResult_OutOfAmountQuestions() {
        service.fillQuestions(env.getProperty("pathToQuestionsQuiz"), env.getProperty("pathToAnswersQuiz"));
        int id = 6;
        Question previousQuestion = service.getQuestionById(id - 1);
        String result = questionsHelper.getQuestionResult(id
                , "answer"
                , statsHelper
                , request
                , previousQuestion
                , "quiz"
                , "filler");
        String expectedResult = "redirect:/tasks/happy-end";
        assertEquals(expectedResult, result);
    }

    @Test
    void getQuestionResult_QuizWithCorrectAnswer() {
        service.fillQuestions(env.getProperty("pathToQuestionsQuiz"), env.getProperty("pathToAnswersQuiz"));
        int id = 2;
        Question previousQuestion = service.getQuestionById(id - 1);
        String result = questionsHelper.getQuestionResult(id
                , previousQuestion.getCorrectAnswer().getText()
                , statsHelper
                , request
                , previousQuestion
                , "quiz"
                , "filler");
        String expectedResult = "question-page";
        assertEquals(expectedResult, result);
    }

    @Test
    void getQuestionResult_QuizWithWrongAnswer() {
        service.fillQuestions(env.getProperty("pathToQuestionsQuiz"), env.getProperty("pathToAnswersQuiz"));
        int id = 2;
        Question previousQuestion = service.getQuestionById(id - 1);
        String expectedResult = "filler";
        String result = questionsHelper.getQuestionResult(id
                , "randomAnswer"
                , statsHelper
                , request
                , previousQuestion
                , "quiz"
                , expectedResult);
        assertEquals(expectedResult, result);
    }

    @Test
    void getQuestionResult_QuestWithCorrectAnswer() {
        service.fillQuestions(env.getProperty("pathToQuestionsQuest"), env.getProperty("pathToAnswersQuest"));
        int id = 2;
        Question previousQuestion = service.getQuestionById(id - 1);
        String result = questionsHelper.getQuestionResult(id
                , previousQuestion.getCorrectAnswer().getText()
                , statsHelper
                , request
                , previousQuestion
                , "quiz"
                , "filler");
        String expectedResult = "question-page";
        assertEquals(expectedResult, result);
    }

    @Test
    void getQuestionResult_QuestWithWrongAnswer() {
        service.fillQuestions(env.getProperty("pathToQuestionsQuest"), env.getProperty("pathToAnswersQuest"));
        int id = 2;
        Question previousQuestion = service.getQuestionById(id - 1);
        String expectedResult = "filler";
        String result = questionsHelper.getQuestionResult(id
                , "randomAnswer"
                , statsHelper
                , request
                , previousQuestion
                , "quiz"
                , expectedResult);
        assertEquals(expectedResult, result);
    }
}















