package ru.javarush.quest.bogdanov.questdelta.repositories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.javarush.quest.bogdanov.questdelta.entities.Answer;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerRepositoryTest {

    static AnswerRepository answerRepository;

    @BeforeAll
    public static void init() {
        answerRepository = new AnswerRepository();
    }

    @Test
    void getAnswersByQuestionIdAndGetItCorrectlySize() {
        List<Answer> answersByQuestionId = answerRepository.findAnswersByQuestionId(2L);
        int actualSize = answersByQuestionId.size();
        int expectedSize = 2;
        List<String> actualTexts = answersByQuestionId.stream()
                .map(answer -> answer.text)
                .toList();
        List<String> expectedTexts = Arrays.asList("тест1", "тест2");
        assertEquals(expectedSize, actualSize);
        assertEquals(expectedTexts, actualTexts);
    }

}