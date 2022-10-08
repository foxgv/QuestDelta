package ua.com.javarush.quest.rbityutskih.service;

import ua.com.javarush.quest.rbityutskih.repository.QuestRepository;

public class QuestService {
    private final QuestRepository questRepository;
    private static QuestService questService;

    private QuestService() {
        questRepository = QuestRepository.get();
    }

    public static QuestService getQuestService() {
        if (questService == null) {
            questService = new QuestService();
        }
        return questService;
    }
}
