package ua.com.javarush.quest.gribanov.questdelta.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


@Builder
@EqualsAndHashCode
public class Question extends AbstractEntity {
    private Long questID;
    private String questionText;
    private boolean isALast = false;

    private boolean isAWin = false;

    Collection<Answer> answers;
    private String image;

    public Question() {
    }

    public Question(Long questID, String questionText, boolean isALast, boolean isAWin, Collection<Answer> answers, String image) {
        this.questID = questID;
        this.questionText = questionText;
        this.isALast = isALast;
        this.isAWin = isAWin;
        this.answers = answers;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getQuestID() {
        return questID;
    }

    public void setQuestID(Long questID) {
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

    public boolean isAWin() {
        return isAWin;
    }

    public void setAWin(boolean AWin) {
        isAWin = AWin;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }
    public void setAnswer(Answer answer){
        if (this.answers == null) {
            this.answers = new ArrayList<>();
        }
        this.answers.add(answer);
    }
}
