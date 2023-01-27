package ua.com.javarush.quest.khmelov.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Getter
@Setter
@ToString

@Entity
@Table(name = "t_answer")
public class Answer implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="question_id")
    private Long questionId;

    private String text;

    @Column(name="next_question_id")
    private Long nextQuestionId;

}
