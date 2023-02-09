package com.javarush.khmelov.repository.impl;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.entity.GameState;
import com.javarush.khmelov.entity.Quest;
import com.javarush.khmelov.entity.Question;
import com.javarush.khmelov.repository.Container;
import com.javarush.khmelov.repository.Repository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionRepositoryTest {
    @BeforeAll
    static void init(){
        Container.init();
    }
    private final Repository<Question> questionRepository = Winter.getBean(QuestionRepository.class);
    private final Repository<Quest> questRepository = Winter.getBean(QuestRepository.class);

    public static Stream<Arguments> getSamplePatternForSearch() {
        return Stream.of(
                Arguments.of(Question.builder().id(0L).build(), 1),
                Arguments.of(Question.builder().id(1234567890L).build(), 0),
                Arguments.of(Question.builder().text("test_text").build(), 1)
        );
    }

    @Test
    @DisplayName("When get all then count>0")
    void getAll() {
        long count = questionRepository.getAll().count();
        assertTrue(count > 0);
    }

    @ParameterizedTest
    @MethodSource("getSamplePatternForSearch")
    @DisplayName("Check find by not null fields")
    public void find(Question question, int count) {
        long actualCount = questionRepository.find(question).count();
        assertEquals(count, actualCount);
    }

    @Test
    void get() {
        Question question = questionRepository.get(0L);
        assertEquals(question.getText(), "test_text");
    }

    @Test
    @DisplayName("When create+update+delete tempQuest then no Exception")
    void createUpdateDelete() {
        Quest quest = questRepository.get(0L);
        Question question = Question.builder().text("test_text_cud").quest(quest).gameState(GameState.PLAY).build();
        questionRepository.create(question);

        question.setText("test_text_cud_update");
        questionRepository.update(question);

        questionRepository.delete(question);
        assertTrue(question.getId() > 0);
    }
}