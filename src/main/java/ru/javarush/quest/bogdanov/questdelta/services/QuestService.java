package ru.javarush.quest.bogdanov.questdelta.services;

import ru.javarush.quest.bogdanov.questdelta.entities.Quest;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.repositories.QuestRepository;

import java.util.List;
import java.util.Optional;

public enum QuestService {

    QUEST_SERVICE;

    private final QuestRepository questRepository = QuestRepository.getInstance();
    private final UserService userService = UserService.USER_SERVICE;

    public List<Quest> getAll() {
        return questRepository.getAll();
    }

    public Quest getQuestById(long id) {
        return questRepository.getByID(id);
    }

    public void create(Quest quest) {
        questRepository.create(quest);
    }

    public String getAuthorLogin(long authorId) {
        Optional<User> user = userService.getUser(authorId);
        return user.map(User::getLogin).orElse("Unknown person");
    }
}
