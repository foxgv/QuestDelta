package ua.com.javarush.quest_spring.ivanov.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import ua.com.javarush.quest_spring.ivanov.entities.Question;
import ua.com.javarush.quest_spring.ivanov.repository.QuestionsRepo;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class QuestionsServiceImplTest {

    @Autowired
    private QuestionsService service;
    @Autowired
    private Environment env;
    @MockBean
    private QuestionsRepo repo;

    @BeforeEach
    void setup() {
        repo.fillQuestions(env.getProperty("pathToQuestionsQuiz"), env.getProperty("pathToAnswersQuiz"));
    }


    @Test
    void getQuestions() {
        HashMap<Integer, Question> expectedResult = repo.getQuestions();
        HashMap<Integer, Question> result = service.getQuestions();
        assertEquals(expectedResult, result);
    }

    @Test
    void getQuestionById() {
        Question expectedResult = repo.getQuestionById(1);
        Question result = service.getQuestionById(1);
        assertEquals(expectedResult, result);
    }

    @Test
    void fillQuestions() {
        verify(repo, times(1)).fillQuestions(env.getProperty("pathToQuestionsQuiz"), env.getProperty("pathToAnswersQuiz"));
    }
}