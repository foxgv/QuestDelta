package ua.com.javarush.quest.khmelov.questdelta.entity;

import java.util.Objects;

public class Answer extends AbstractEntity {
    private long questionID;
    private String answerText;

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Answer answer = (Answer) o;
        return questionID == answer.questionID && Objects.equals(answerText, answer.answerText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), questionID, answerText);
    }
}
