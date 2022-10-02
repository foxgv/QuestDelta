package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Quest;
import ru.javarush.quest.bogdanov.questdelta.repositories.QuestRepository;

import java.util.List;

public enum QuestService {

    QUEST_SERVICE;

    private final QuestRepository questRepository = QuestRepository.getInstance();

    public List<Quest> getAll() {
        return questRepository.getAll();
    }

    public void create(Quest quest) {
        questRepository.create(quest);
    }
}
