package ru.javarush.volokitin.questdelta.mapper;

import ru.javarush.volokitin.questdelta.dto.GameDTO;
import ru.javarush.volokitin.questdelta.entity.Game;

public class StatisticsMapper {

    public static GameDTO get(Game game) {
        return GameDTO.with()
                .user(game.getUser())
                .date(game.getDate())
                .correctAnswersCount(game.getCorrectAnswersCount())
                .get();
    }
}
