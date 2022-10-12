import org.junit.jupiter.api.Test;
import ua.com.javarush.quest.rbityutskih.entity.Game;
import ua.com.javarush.quest.rbityutskih.entity.GameState;
import ua.com.javarush.quest.rbityutskih.service.GameService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {

    private final GameService gameService = GameService.INSTANCE;


    @Test
    void create() {
        Long id = gameService.create("test");
        Game game = gameService.get(id);
        assertEquals("test", game.getUserName());
        assertEquals(1L, game.getCurrentQuestionId());
        assertEquals(GameState.PLAY, game.getState());
        assertEquals(1L, game.getQuestId());
    }

    @Test
    void getAll(){
        gameService.create("test");
        assertEquals(2, gameService.getAll().size());
    }


}