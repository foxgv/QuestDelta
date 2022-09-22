package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Quest {

    private static final AtomicLong ID_QUEST_COUNTER = new AtomicLong(1);

    public long id;

    List<Question> questionList;

}
