package ua.com.javarush.quest_spring.ivanov.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ua.com.javarush.quest_spring.ivanov.entities.Game;
import ua.com.javarush.quest_spring.ivanov.entities.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionsControllerTest {

    @Autowired
    MockMvc mockMvc;

    private User user;

    @BeforeEach
    void setup() {
        user = new User(1
                , new Game(1, 2, 3, 0)
                , "username"
                , "pass"
                , "email");
    }

    @Test
    void showQuestStart() throws Exception {
        mockMvc.perform(get("/tasks/start"))
                .andExpect(status().isOk())
                .andExpect(view().name("tasks-start-page"));

    }

    @Test
    void showQuestionQuiz() throws Exception {
        mockMvc.perform(get("/tasks/start-quiz")
                        .sessionAttr("user", user))
                .andExpect(status().isOk())
                .andExpect(view().name("question-page"));
    }


    @Test
    void showQuestionQuest() throws Exception {
        mockMvc.perform(get("/tasks/start-quest")
                        .sessionAttr("user", user))
                .andExpect(status().isOk())
                .andExpect(view().name("question-page"));
    }

    @Test
    void showFailPage() throws Exception {
        mockMvc.perform(get("/tasks/fail")
                        .sessionAttr("user", user))
                .andExpect(status().isOk())
                .andExpect(view().name("fail-page"));
    }

    @Test
    void showHappyEndingPage() throws Exception {
        mockMvc.perform(post("/success_change"))
                .andExpect(status().isOk());
    }
}















