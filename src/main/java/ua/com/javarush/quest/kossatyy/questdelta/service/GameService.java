package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.config.Container;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameSessionDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.*;
import ua.com.javarush.quest.kossatyy.questdelta.error.AppError;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.GameMapper;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.GameSessionMapper;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.Mapper;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.UserMapper;
import ua.com.javarush.quest.kossatyy.questdelta.repository.GameRepository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.GameSessionRepository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class GameService {

    private final Repository<Game> gameRepository = Container.getInstance(GameRepository.class);
    private final Repository<GameSession> gameSessionRepository = Container.getInstance(GameSessionRepository.class);
    private final Mapper<GameSessionDto, GameSession> gameSessionMapper = new GameSessionMapper();
    private final Mapper<GameDto, Game> gameMapper = new GameMapper();
    private final UserService userService = new UserService();


    public GameDto getGame(Long id) {
        return gameMapper.toDto(gameRepository.getById(id));
    }

    public GameSessionDto getSession(UserDto userDto, Long gameId) {
        Game game = gameRepository.getById(gameId);
        GameSessionDto sessionDto;
        if (userDto == null) {
            sessionDto = gameSessionMapper.toDto(GameSession.builder()
                    .gameId(gameId)
                    .currentQuestionId(game.getStartQuestionId())
                    .build());
            return sessionDto;
        }

        List<Long> gamesWithSession = userDto.getGamesIdWithSession();
        if (gamesWithSession.contains(gameId)) {
            GameSession findSession = GameSession.builder()
                    .gameId(gameId)
                    .userId(userDto.getId())
                    .build();
            sessionDto = gameSessionRepository.find(findSession)
                    .findFirst()
                    .map(gameSessionMapper::toDto)
                    .orElseThrow(() -> new AppError("Session not found for gameID - " + gameId + " userID - " + userDto.getId()));
            // TODO replace for display error with redirect
        } else {
            GameSession userSession = GameSession.builder()
                    .userId(userDto.getId())
                    .gameId(gameId)
                    .currentQuestionId(game.getStartQuestionId())
                    .build();
            sessionDto = gameSessionMapper.toDto(userSession);
            gameSessionRepository.create(userSession);
            userService.update(userDto.getId(), userSession);
        }

        return sessionDto;
    }

    public void updateRequirement(GameSessionDto gameSessionDto, Requirement requirement) {
        gameSessionDto.setRequirement(requirement);
        Long id = gameSessionDto.getId();
        if (id != null) {
            GameSession gameSession = gameSessionRepository.getById(id);
            gameSession.setRequirement(requirement);
            gameSessionRepository.update(gameSession);
        }
    }

    public void updateStatus(GameSessionDto gameSessionDto, GameStatus status) {
        gameSessionDto.setGameStatus(status);
        Long id = gameSessionDto.getId();
        if (id != null) {
            GameSession gameSession = gameSessionRepository.getById(gameSessionDto.getId());
            gameSession.setGameStatus(status);
            gameSessionRepository.update(gameSession);
        }
    }
}
