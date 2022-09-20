package ua.com.javarush.quest.ryabov.questdelta.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class QuestRepositoryImplementation implements QuestRepository{
    private final Map<String, String> quest = new HashMap<>();
    public static final QuestRepositoryImplementation questImplementation = new QuestRepositoryImplementation();

    @Override
    public Optional<String> get(String answer) {
        return Optional.ofNullable(quest.get(answer));
    }
    public static QuestRepositoryImplementation get(){
        return questImplementation;
    }
    private QuestRepositoryImplementation(){
        quest.put("", "");
    }
}
