package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Question {

    private static final AtomicLong ID_QUESTION_COUNTER = new AtomicLong(1);

    public long id;

    public List<Answer> answerList;

    public long questId;

    public long correctAnswerId;

    public long incorrectAnswerId;

    public String text;

    public Question(List<Answer> answerList, long questId, long correctAnswerId, long incorrectAnswerId, String text) {
        this.id = ID_QUESTION_COUNTER.getAndIncrement();
        this.answerList = answerList;
        this.questId = questId;
        this.correctAnswerId = correctAnswerId;
        this.incorrectAnswerId = incorrectAnswerId;
        this.text = text;
    }

    public Question(long questId, long correctAnswerId, String text) {
        this.id = ID_QUESTION_COUNTER.getAndIncrement();
        this.questId = questId;
        this.correctAnswerId = correctAnswerId;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
