package ru.javarush.quest.bogdanov.questdelta.repositories;

import ru.javarush.quest.bogdanov.questdelta.entities.Quest;
import ru.javarush.quest.bogdanov.questdelta.entities.User;

import java.util.List;

public class QuestRepository implements Repository<Quest> {

    @Override
    public List<Quest> getAll() {
        return null;
    }

    @Override
    public User getByID(long id) {
        return null;
    }

    @Override
    public boolean create(Quest entity) {
        return false;
    }

    @Override
    public boolean update(Quest entity) {
        return false;
    }

    @Override
    public boolean delete(Quest entity) {
        return false;
    }
}
