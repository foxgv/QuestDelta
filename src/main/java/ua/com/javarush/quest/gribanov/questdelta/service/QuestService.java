package ua.com.javarush.quest.gribanov.questdelta.service;

import ua.com.javarush.quest.gribanov.questdelta.dto.QuestDTO;
import ua.com.javarush.quest.gribanov.questdelta.mapper.Mapper;
import ua.com.javarush.quest.gribanov.questdelta.repository.QuestRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuestService {

    private final QuestRepository questRepository = QuestRepository.get();

    private static final QuestService questService = new QuestService();

    private QuestService (){

    }
    public static QuestService get(){
        return questService;
    }
    public Collection<QuestDTO> getAll() {
        return questRepository.getAll().stream()
                .map(Mapper.quest::getDTO)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
