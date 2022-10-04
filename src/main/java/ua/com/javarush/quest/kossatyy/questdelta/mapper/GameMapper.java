package ua.com.javarush.quest.kossatyy.questdelta.mapper;

import ua.com.javarush.quest.kossatyy.questdelta.dto.GameDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.UserDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Game;
import ua.com.javarush.quest.kossatyy.questdelta.entity.User;

public class GameMapper implements Mapper<GameDto, Game> {

    @Override
    public GameDto toDto(Game entity) {
        return GameDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .image(entity.getImage())
                .authorId(entity.getAuthorId())
                .startQuestionId(entity.getStartQuestionId())
                .requirements(entity.getRequirements())
                .levels(entity.getLevels().size())
                .build();
    }
}
