package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.concurrent.atomic.AtomicLong;

public class Answer {

    private static final AtomicLong ID_ANSWER_COUNTER = new AtomicLong(1);

    public long id;

    public long questionId;

    public boolean correct;

    public String text;

    public Answer(long questionId, boolean correct, String text) {
        this.id = ID_ANSWER_COUNTER.getAndIncrement();
        this.questionId = questionId;
        this.correct = correct;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
