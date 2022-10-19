package ua.com.javarush.quest.gribanov.questdelta.entity;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
@EqualsAndHashCode
public class Quest extends AbstractEntity {
    private String name;
    private boolean isActive = true;
    private Long authorID;
    private Long firstQuestionID;
    private Collection<Question> questions;

    private String image;

    public Quest() {
    }

    public Quest(String name, boolean isActive, Long authorID, Long firstQuestionID, Collection<Question> questions, String image) {
        this.name = name;
        this.isActive = isActive;
        this.authorID = authorID;
        this.questions = questions;
        this.image = image;
        this.firstQuestionID = firstQuestionID;
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

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public Long getFirstQuestionID() {
        return firstQuestionID;
    }

    public void setFirstQuestionID(Long firstQuestionID) {
        this.firstQuestionID = firstQuestionID;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static class QuestBuilder {
        private String name;
        private boolean isActive = true;
        private Long authorID;
        private Collection<Question> questions;
        private String image;

        private Long firstQuestionID;

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

        public QuestBuilder authorID(Long authorID){
            this.authorID = authorID;
            return this;
        }

        public QuestBuilder firstQuestionID(Long firstQuestionID){
            this.firstQuestionID = firstQuestionID;
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
            return new Quest(name, isActive, authorID, firstQuestionID, questions, image);
        }
    }
}
