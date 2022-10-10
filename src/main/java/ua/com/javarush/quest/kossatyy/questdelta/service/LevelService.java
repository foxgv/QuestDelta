package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.dto.ButtonDto;
import ua.com.javarush.quest.kossatyy.questdelta.dto.LevelDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Button;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Level;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;
import ua.com.javarush.quest.kossatyy.questdelta.mapper.LevelMapper;
import ua.com.javarush.quest.kossatyy.questdelta.repository.LevelRepository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.Repository;
import ua.com.javarush.quest.kossatyy.questdelta.config.Container;

import java.util.List;

public class LevelService {

    private final Repository<Level> levelRepository = Container.getInstance(LevelRepository.class);
    private final ButtonService buttonService = new ButtonService();
    private final LevelMapper levelMapper = new LevelMapper();


    public LevelDto getLevel(Long levelId, Requirement requirement) {
        Level level = levelRepository.getById(levelId);
        LevelDto levelDto = levelMapper.toDto(level);
        List<Button> buttons = level.getButtons();
        List<ButtonDto> buttonDtos = buttons.stream()
                .map(button -> buttonService.getBtnDto(button, requirement))
                .toList();
        levelDto.setButtons(buttonDtos);

        return levelDto;
    }

    public Long getNextLevelId(Long levelId, Requirement requirement, int buttonNumber) {
        Level level = levelRepository.getById(levelId);
        List<Button> buttons = level.getButtons();
        Button button = buttons.get(buttonNumber);

        return buttonService.getNextLevelId(button, requirement);
    }
}
