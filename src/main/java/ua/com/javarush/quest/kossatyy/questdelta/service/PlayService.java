package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.dto.GameDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Game;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.GameMapper;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.Mapper;
import ua.com.javarush.quest.kossatyy.questdelta.repository.GameRepository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.Repository;
import ua.com.javarush.quest.kossatyy.questdelta.config.Container;

import java.util.Collection;
import java.util.Comparator;

public class PlayService {

    private final Repository<Game> gameRepository = Container.getInstance(GameRepository.class);
    private final Mapper<GameDto, Game> gameMapper = new GameMapper();


    public Collection<GameDto> getAll() {
        return gameRepository.getAll().stream()
                .sorted(Comparator.comparing(Game::getName))
                .map(gameMapper::toDto)
                .toList();
    }
}
