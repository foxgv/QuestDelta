package com.javarush.quest.bulimov.questdelta.services;

import com.javarush.quest.bulimov.questdelta.entity.Game;
import com.javarush.quest.bulimov.questdelta.entity.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private final GameService gameService = GameService.INSTANCE;


    @Test
    void create() {
        Long id = gameService.create("test");
        Game game = gameService.get(id);
        assertEquals("test", game.getUserName());
        assertEquals(1L, game.getCurrentQuestionId());
        assertEquals(GameStatus.PLAY, game.getStatus());
        assertEquals(1L, game.getQuestId());
    }

    @Test
    void getAll(){
        gameService.create("test");
        assertEquals(2, gameService.getAll().size());
    }


}