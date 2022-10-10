package ua.com.javarush.quest.kossatyy.questdelta.mapper;

import ua.com.javarush.quest.kossatyy.questdelta.dto.LevelDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Level;

public class LevelMapper implements Mapper<LevelDto, Level> {

    @Override
    public LevelDto toDto(Level entity) {
        return LevelDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .image(entity.getImage())
                .description(entity.getDescription())
                .build();
    }
}
