package ua.com.javarush.quest.rbityutskih.service;

import ua.com.javarush.quest.rbityutskih.entity.Game;
import ua.com.javarush.quest.rbityutskih.entity.GameState;
import ua.com.javarush.quest.rbityutskih.repository.GameRepository;
import ua.com.javarush.quest.rbityutskih.repository.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
public enum GameService {

    /**
     *
     */
    INSTANCE;
    private final Repository<Game> gameRepository = GameRepository.get();


    public Collection<Game> getAll(){
        return gameRepository.getAll()
                .toList();
    }

    public Game get(Long id){

        return gameRepository.get(id);
    }


    public void update(Game game) {
        gameRepository.update(game);
    }

    public Long create(String name) {
        Game game = Game.with()
                .questId(1L)
                .currentQuestionId(1L)
                .userName(name)
                .state(GameState.PLAY)
                .startTime(LocalDateTime.now())
                .build();//.startDataTimeQuest(LocalDateTime.now())

        return gameRepository.create(game);
    }
    //private Optional<GameDto> fill(Game game) {
       // Optional<GameDto> gameDto = game(game);
       // Optional<QuestionDto> questionDto = questionService.get(game.getCurrentQuestionId());
       // gameDto.orElseThrow().setQuestion(questionDto.orElseThrow());
       // return gameDto;
   // }

   // private Optional<GameDto> game(Game game) {
    //}

    public void delete(Game game){
        gameRepository.delete(game);
    }
}
