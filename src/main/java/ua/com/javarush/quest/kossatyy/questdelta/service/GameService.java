package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.config.Container;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameSessionDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Game;
import ua.com.javarush.quest.kossatyy.questdelta.entity.GameSession;
import ua.com.javarush.quest.kossatyy.questdelta.entity.GameStatus;
import ua.com.javarush.quest.kossatyy.questdelta.entity.User;
import ua.com.javarush.quest.kossatyy.questdelta.error.AppError;
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



    public Game getGame(Long id) {
        return gameRepository.getById(id);
    }

    public GameSessionDto getSession(UserDto user, Long gameId) {
        Game game = gameRepository.getById(gameId);
        GameSessionDto session;
        if (user == null) {
            session = gameSessionMapper.toDto(GameSession.builder()
                    .gameId(gameId)
                    .gameStatus(GameStatus.PLAY)
                    .currentQuestionId(game.getStartQuestionId())
                    .build());
            return session;
        }

        List<Long> gamesWithSession = user.getGamesIdWithSession();
        if (gamesWithSession.contains(gameId)) {
            GameSession findSession = GameSession.builder()
                    .gameId(gameId)
                    .userId(user.getId())
                    .build();
            session = gameSessionRepository.find(findSession)
                    .findFirst()
                    .map(gameSessionMapper::toDto)
                    .orElseThrow(() -> new AppError("Session not found for gameID - " + gameId + " userID - " + user.getId()));
        } else {
            session = gameSessionMapper.toDto(GameSession.builder()
                    .userId(user.getId())
                    .gameId(gameId)
                    .currentQuestionId(game.getStartQuestionId())
                    .gameStatus(GameStatus.PLAY)
                    .build());
        }

        return session;
    }
}
