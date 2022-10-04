package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.entity.Level;
import ua.com.javarush.quest.kossatyy.questdelta.repository.LevelRepository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.Repository;
import ua.com.javarush.quest.kossatyy.questdelta.config.Container;

public class LevelService {

    private final Repository<Level> levelRepository =  Container.getInstance(LevelRepository.class);

    public Level getLevel(Long levelId) {
        return levelRepository.getById(levelId);
    }
}
