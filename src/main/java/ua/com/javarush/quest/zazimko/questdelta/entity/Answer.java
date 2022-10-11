package ua.com.javarush.quest.zazimko.questdelta.entity;

import lombok.Builder;

import java.util.Objects;

@Builder(builderMethodName = "with")
public class Answer {
    final private String text;
    Long id;
    Long nextQuestionId;

    public Answer(String text, Long id, Long nextQuestionId) {
        this.text = text;
        this.id = id;
        this.nextQuestionId = nextQuestionId;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(Long nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(text, answer.text) && Objects.equals(id, answer.id) && Objects.equals(nextQuestionId, answer.nextQuestionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, id, nextQuestionId);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "text='" + text + '\'' +
                ", id=" + id +
                ", nextQuestionId=" + nextQuestionId +
                '}';
    }
}
