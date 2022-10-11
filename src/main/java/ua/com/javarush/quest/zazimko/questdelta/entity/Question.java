package ua.com.javarush.quest.zazimko.questdelta.entity;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
@Builder(builderMethodName = "with")
public class Question {
    Long id;
    final private Collection<Answer> answers=new ArrayList<>();

    private final String text;

    public Question(Long id, String text) {
        this.id = id;
        this.text = text;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(answers, question.answers) && Objects.equals(text, question.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answers, text);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", answers=" + answers +
                ", text='" + text + '\'' +
                '}';
    }
}
