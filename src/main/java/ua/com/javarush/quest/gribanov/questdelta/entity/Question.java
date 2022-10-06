package ua.com.javarush.quest.gribanov.questdelta.entity;

import lombok.Builder;

import java.util.Collection;
import java.util.Objects;


@Builder
public class Question extends AbstractEntity {
    private long questID;
    private String questionText;
    private boolean isALast = false;
    Collection<Answer> answers;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getQuestID() {
        return questID;
    }

    public void setQuestID(long questID) {
        this.questID = questID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isALast() {
        return isALast;
    }

    public void setALast(boolean ALast) {
        isALast = ALast;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Question question = (Question) o;
        return questID == question.questID && isALast == question.isALast && Objects.equals(questionText, question.questionText) && Objects.equals(answers, question.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), questID, questionText, isALast, answers);
    }
}
