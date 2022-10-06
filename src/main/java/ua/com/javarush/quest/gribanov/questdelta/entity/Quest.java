package ua.com.javarush.quest.gribanov.questdelta.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Quest extends AbstractEntity {
    private String name;
    private boolean isActive = true;
    private long authorID;
    private Collection<Question> questions;

    private String image;

    public Quest(String name, boolean isActive, long authorID, Collection<Question> questions, String image) {
        this.name = name;
        this.isActive = isActive;
        this.authorID = authorID;
        this.questions = questions;
        this.image = image;
    }

    public static QuestBuilder builder(){
        return new QuestBuilder();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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

    public static class QuestBuilder {
        private String name;
        private boolean isActive = true;
        private long authorID;
        private Collection<Question> questions;
        private String image;

        QuestBuilder() {
        }

        public QuestBuilder name(String name){
            this.name = name;
            return this;
        }

        public QuestBuilder isActive(boolean isActive){
            this.isActive = isActive;
            return this;
        }

        public QuestBuilder authorID(long authorID){
            this.authorID = authorID;
            return this;
        }

        public QuestBuilder question(Question question){
            if (questions == null) {
                questions = new ArrayList<>();
            }
            questions.add(question);
            return this;
        }

        public QuestBuilder questions(Collection<Question> questions){
            if (this.questions == null) {
                this.questions = new ArrayList<>();
            }
            this.questions.addAll(questions);
            return this;
        }

        public QuestBuilder image(String image){
            this.image = image;
            return this;
        }

        public Quest build(){
            return new Quest(name, isActive, authorID, questions, image);
        }
    }
}
