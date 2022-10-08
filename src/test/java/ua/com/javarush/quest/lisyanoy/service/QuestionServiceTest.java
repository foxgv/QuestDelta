package ua.com.javarush.quest.lisyanoy.service;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.com.javarush.quest.lisyanoy.repository.AnswerRepository;
import ua.com.javarush.quest.lisyanoy.repository.QuestionRepository;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuestionServiceTest {

    @Mock
    private HttpServletRequest request;
    private final QuestionRepository questionRepository = new QuestionRepository();
    private final AnswerRepository answerRepository = new AnswerRepository();
    private final QuestionService questionService = QuestionService.INSTANCE;

    @BeforeAll
    public void load() {
        answerRepository.createAnswers();
        questionRepository.createQuestion();
        questionService.createMapQuestionAnswers();
    }

    @Order(1)
    @ParameterizedTest
    @CsvSource({
        "0, 0, Принять вызов",
        "0, 1, Отклонить вызов",
        "1, 1, Отказаться подниматься на мостик",
        "2, 0, Рассказать правду о себе"
    })
    @DisplayName("check create map question - answers")
    public void getAnswer(int numberQuestion, int numberAnswer, String expectedAnswer) {
        Map<Integer, List<String>> mapQuestionAnswers = questionService.mapQuestionAnswers;
        String actualAnswer = mapQuestionAnswers.get(numberQuestion).get(numberAnswer);
        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10, 0",
            "11, 11, 1",
            "21, 21, 1",
            "30, 30, 0"
    })
    @DisplayName("check number answer from request")
    public void getNumberAnswer(String answer, String value, int expectedNumberAnswer) {
        Mockito.when(request.getParameter(answer)).thenReturn(value);
        int answerRequest = Integer.parseInt(request.getParameter(answer));
        int actualQuestion = answerRequest / 10 - 1;
        int actualAnswer = answerRequest % 10;
        Map<Integer, List<String>> mapQuestionAnswers = questionService.mapQuestionAnswers;
        List<String> question = mapQuestionAnswers.get(actualQuestion);
        int actualNumberAnswer = question.indexOf(question.get(actualAnswer));
        assertEquals(expectedNumberAnswer, actualNumberAnswer);
    }
}