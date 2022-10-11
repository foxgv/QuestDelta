package ua.com.javarush.quest.zazimko.questdelta.entity;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Builder(builderMethodName = "with")
public class Quest {
    Long id;
    private final String name;
    private final String text;
    Long startQuestionId;
    private final Collection<Question> questions=new ArrayList<>();

    public Quest(Long id, String name, String text, Long startQuestionId) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.startQuestionId = startQuestionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Long getStartQuestionId() {
        return startQuestionId;
    }

    public void setStartQuestionId(Long startQuestionId) {
        this.startQuestionId = startQuestionId;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
        return Objects.equals(id, quest.id) && Objects.equals(name, quest.name) && Objects.equals(text, quest.text) && Objects.equals(startQuestionId, quest.startQuestionId) && Objects.equals(questions, quest.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, startQuestionId, questions);
    }

    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", startQuestionId=" + startQuestionId +
                ", questions=" + questions +
                '}';
    }
}
