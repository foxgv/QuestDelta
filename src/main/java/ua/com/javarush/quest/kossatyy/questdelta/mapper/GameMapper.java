package ua.com.javarush.quest.kossatyy.questdelta.mapper;

import ua.com.javarush.quest.kossatyy.questdelta.dto.GameDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Game;

public class GameMapper implements Mapper<GameDto, Game> {

    @Override
    public GameDto toDto(Game entity) {
        return GameDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .image(entity.getImage())
                .authorId(entity.getAuthorId())
                .startLevelId(entity.getStartQuestionId())
                .requirementDescription(entity.getRequirementDescription())
                .requirements(entity.getRequirements())
                .build();
    }
}
