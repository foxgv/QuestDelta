package ua.com.javarush.quest.ryabov.questdelta.repository;

import java.util.Optional;

public interface QuestRepository {
    Optional<String> get(String answer);
}
