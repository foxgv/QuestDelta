package com.javarush.khmelov.service;

import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.GameDto;
import com.javarush.khmelov.dto.ui.QuestionDto;
import com.javarush.khmelov.entity.*;
import com.javarush.khmelov.mapping.Mapper;
import com.javarush.khmelov.repository.impl.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final QuestRepository questRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    private final QuestionService questionService;

    public Optional<GameDto> getGame(FormData formData, Long userId) {
        Game gamePattern = Mapper.game.parse(formData);
        gamePattern.setGameState(GameState.PLAY);
        User user = userRepository.get(userId);
        gamePattern.setUserId(userId);
        Optional<Game> currentGame = gameRepository
                .find(gamePattern)
                .max(Comparator.comparingLong(Game::getId));
        if (currentGame.isPresent()) {
            return fill(currentGame.get());
        } else if (gamePattern.getQuestId() != null) {
            return fill(getNewGame(userId, gamePattern.getQuestId()));
        } else {
            return Optional.empty();
        }
    }

    public Optional<GameDto> checkAnswer(Long gameId, Long answerId) {
        gameRepository.beginTransactional();
        try {
            Game game = gameRepository.get(gameId);
            if (game.getGameState() == GameState.PLAY) {
                Answer answer = answerRepository.get(answerId);
                Long nextQuestionId = answer != null
                        ? answer.getNextQuestionId()
                        : game.getCurrentQuestionId();
                game.setCurrentQuestionId(nextQuestionId);
                Question question = questionRepository.get(nextQuestionId);
                game.setGameState(question.getGameState());
                gameRepository.update(game);
            } else {
                game = getNewGame(game.getUserId(), game.getQuestId());
            }
            return fill(game);
        } finally {
            gameRepository.endTransactional();
        }
    }

    private Game getNewGame(Long userId, Long questId) {
        gameRepository.beginTransactional();
        try {
            Quest quest = questRepository.get(questId);
            Long startQuestionId = quest.getStartQuestionId();
            Question firstQuestion = questionRepository.get(startQuestionId);
            Game newGame = Game.builder()
                    .questId(questId)
                    .currentQuestionId(startQuestionId)
                    .gameState(firstQuestion.getGameState())
                    .userId(userId) //from session
                    .build();
            userRepository.get(userId).getGames().add(newGame);
            gameRepository.create(newGame);
            return newGame;
        } finally {
            gameRepository.endTransactional();
        }
    }

    private Optional<GameDto> fill(Game game) {
        Optional<GameDto> gameDto = Mapper.game.get(game);
        Optional<QuestionDto> questionDto = questionService.get(game.getCurrentQuestionId());
        gameDto.orElseThrow().setQuestion(questionDto.orElseThrow());
        return gameDto;
    }
}
