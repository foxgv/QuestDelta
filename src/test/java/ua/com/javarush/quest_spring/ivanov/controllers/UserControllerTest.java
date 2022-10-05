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
class UserControllerTest {

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
    void showProfilePage() throws Exception {
        mockMvc.perform(get("/profile")
                        .sessionAttr("user", user))
                .andExpect(status().isOk())
                .andExpect(view().name("profile-page"));
    }

    @Test
    void showDeletePage() throws Exception {
        mockMvc.perform(post("/delete")
                        .sessionAttr("user", user))
                .andExpect(status().isOk())
                .andExpect(view().name("delete-page"));
    }

    @Test
    void showSuccessChangesPage() {
    }
}