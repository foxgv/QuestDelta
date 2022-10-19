package ua.com.javarush.quest.gribanov.questdelta.service;

import ua.com.javarush.quest.gribanov.questdelta.dto.GameDTO;
import ua.com.javarush.quest.gribanov.questdelta.entity.Answer;
import ua.com.javarush.quest.gribanov.questdelta.entity.Game;
import ua.com.javarush.quest.gribanov.questdelta.entity.GameState;
import ua.com.javarush.quest.gribanov.questdelta.mapper.Mapper;
import ua.com.javarush.quest.gribanov.questdelta.repository.AnswerRepository;
import ua.com.javarush.quest.gribanov.questdelta.repository.GameRepository;

import java.util.Optional;

public class GameService {

    private static final GameService gameService = new GameService();

    private GameService (){

    }
    public static GameService get(){
        return gameService;
    }
    public Optional<GameDTO> getGame(long userID, long questID){
        Game gameTemplate = Game.builder()
                .userID(userID)
                .state(GameState.IN_PROGRESS)
                .build();
        Game existingGame = GameRepository.get().find(gameTemplate).findFirst().orElse(null);
        if (existingGame != null){
            return Mapper.game.getDTO(existingGame);
        } else {
            GameRepository.get().add(gameTemplate);
            gameTemplate.setQuestID(questID);
            gameTemplate.setCurrentQuestionID(1100);
            return Mapper.game.getDTO(gameTemplate);
        }
    }

    public Optional<GameDTO> updateGame(Long gameID, Long answerID){
        Game existingGame = GameRepository.get().get(gameID);
        Answer answer = AnswerRepository.get().get(answerID);
        if (existingGame != null && answer != null){
            existingGame.setCurrentQuestionID(answer.getNextQuestionID());
            return Mapper.game.getDTO(existingGame);
        } else {
            return Optional.empty();
        }
    }
}
