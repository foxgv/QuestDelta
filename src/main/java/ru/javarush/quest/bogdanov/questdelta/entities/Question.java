package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Question {

    private static final AtomicLong ID_QUESTION_COUNTER = new AtomicLong(1);

    public long id;

    public List<Answer> answerList;

    public long questId;

    public long correctQuestionId;

    public long incorrectQuestionId;

    public String text;

    public Question(List<Answer> answerList, long questId, long correctQuestionId, long incorrectQuestionId, String text) {
        this.id = ID_QUESTION_COUNTER.getAndIncrement();
        this.answerList = answerList;
        this.questId = questId;
        this.correctQuestionId = correctQuestionId;
        this.incorrectQuestionId = incorrectQuestionId;
        this.text = text;
    }

    public Question(long questId, long correctQuestionId, String text) {
        this.id = ID_QUESTION_COUNTER.getAndIncrement();
        this.questId = questId;
        this.correctQuestionId = correctQuestionId;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public long getQuestId() {
        return questId;
    }

    public void setQuestId(long questId) {
        this.questId = questId;
    }

    public long getCorrectQuestionId() {
        return correctQuestionId;
    }

    public void setCorrectQuestionId(long correctQuestionId) {
        this.correctQuestionId = correctQuestionId;
    }

    public long getIncorrectQuestionId() {
        return incorrectQuestionId;
    }

    public void setIncorrectQuestionId(long incorrectQuestionId) {
        this.incorrectQuestionId = incorrectQuestionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", correctQuestionId=" + correctQuestionId +
                ", incorrectQuestionId=" + incorrectQuestionId +
                ", text='" + text + '\'' +
                '}';
    }
}
