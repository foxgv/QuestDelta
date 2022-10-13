package ua.com.javarush.quest_spring.ivanov.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ua.com.javarush.quest_spring.ivanov.entities.Game;
import ua.com.javarush.quest_spring.ivanov.entities.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void showLoginPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("login-page"))
                .andExpect(model().attributeExists("user"));

    }

    @Test
    void showMainPageLogIn() throws Exception {

        mockMvc.perform(post("/main_page")
                        .param("action", "sigh_in"))
                .andExpect(status().isOk());
    }


    @Test
    void showMainPage() throws Exception {
        mockMvc.perform(get("/main_page"))
                .andExpect(status().isOk())
                .andExpect(view().name("main-page"));
    }

    @Test
    void showStatsPage() throws Exception {
        User user = new User(1
                , new Game(1, 2, 3, 0)
                , "username"
                , "pass"
                , "email");
        MockHttpServletRequestBuilder updateDetails = get("/stats").sessionAttr("user", user);
        mockMvc.perform(updateDetails)
                .andExpect(status().isOk())
                .andExpect(model().attribute("user", user))
                .andExpect(view().name("stats-page"));
    }
}


















