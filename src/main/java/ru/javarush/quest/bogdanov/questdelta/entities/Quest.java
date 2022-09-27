package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Quest {

    private static final AtomicLong ID_QUEST_COUNTER = new AtomicLong(1);

    public long id;

    public List<Question> questionList;

    public String name;

    public String description;

    public long authorId;

    public Quest(List<Question> questionList, String name, String description, long authorId) {
        this.id = ID_QUEST_COUNTER.getAndIncrement();
        this.questionList = questionList;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
    }
}
