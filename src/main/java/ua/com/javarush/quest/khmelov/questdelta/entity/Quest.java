package ua.com.javarush.quest.khmelov.questdelta.entity;

import java.util.Collection;
import java.util.Objects;

public class Quest extends AbstractEntity {
    private String name;
    private boolean isActive = true;
    private long authorID;
    private Collection<Question> questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(long authorID) {
        this.authorID = authorID;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Quest quest = (Quest) o;
        return isActive == quest.isActive && authorID == quest.authorID && Objects.equals(name, quest.name) && Objects.equals(questions, quest.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, isActive, authorID, questions);
    }
}
