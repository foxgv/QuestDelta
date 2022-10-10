package ua.com.javarush.quest.gribanov.questdelta.mapper;

import ua.com.javarush.quest.gribanov.questdelta.dto.ClientData;
import ua.com.javarush.quest.gribanov.questdelta.dto.QuestDTO;
import ua.com.javarush.quest.gribanov.questdelta.entity.AbstractEntity;
import ua.com.javarush.quest.gribanov.questdelta.entity.Quest;

import java.util.Optional;

public class QuestMapper implements Mapper<Quest, QuestDTO> {
    @Override
    public Optional<QuestDTO> get(Quest quest) {
        return quest != null
                ? Optional.of(QuestDTO.builder()
                .id(quest.getId())
                .name(quest.getName())
                .authorId(quest.getAuthorID())
                .build()
        ) : Optional.empty();
    }

    @Override
    public Quest create(ClientData data) {
        return null;
    }
}
