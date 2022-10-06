package ua.com.javarush.quest.gribanov.questdelta.repository;

import ua.com.javarush.quest.gribanov.questdelta.entity.Quest;

import java.util.Collection;
import java.util.stream.Collectors;

public class QuestRepository extends AbstractRepository<Quest> {

    private static final QuestRepository questRepository = new QuestRepository();
    public static QuestRepository get(){
        return questRepository;
    }
    private QuestRepository(){

    }
    @Override
    public Collection<Quest> find(Quest template) {
        return repository.values().stream()
                .filter(entity->isCoincide(template, entity, Quest::getId)
                        &&isCoincide(template, entity, Quest::getName)
                        &&isCoincide(template, entity, Quest::isActive)
                        &&isCoincide(template, entity, Quest::getAuthorID)
                        &&isCoincide(template, entity, Quest::getQuestions)
                        &&isCoincide(template, entity, Quest::getImage))
                .collect(Collectors.toList());
    }
}
