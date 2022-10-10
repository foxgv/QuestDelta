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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Quest " + id +
                ": name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
