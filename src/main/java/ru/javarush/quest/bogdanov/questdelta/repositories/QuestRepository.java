package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Quest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestRepository implements Repository<Quest> {

    private final Map<Long, Quest> map = new HashMap<>();

    @Override
    public List<Quest> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Quest getByID(long id) {
        return map.get(id);
    }

    @Override
    public void create(Quest entity) {
    }

    @Override
    public void update(Quest entity) {
        map.replace(entity.id, entity);
    }

    @Override
    public void delete(Quest entity) {
        map.remove(entity.id, entity);
    }
}
