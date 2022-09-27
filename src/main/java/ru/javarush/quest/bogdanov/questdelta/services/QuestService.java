package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Quest;
import ru.javarush.quest.bogdanov.questdelta.repositories.QuestRepository;
import ru.javarush.quest.bogdanov.questdelta.repositories.Repository;

import java.util.List;

public enum QuestService {

    QUEST_SERVICE;

    private final Repository<Quest> questRepository = new QuestRepository();

    public List<Quest> getAll() {
        return questRepository.getAll();
    }

    public Quest getQuest(long id) {
        return questRepository.getByID(id);
    }

    public void create(Quest quest) {
        questRepository.create(quest);
    }
}
