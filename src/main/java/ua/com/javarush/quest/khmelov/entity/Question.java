package ua.com.javarush.quest.khmelov.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Getter
@Setter
@ToString

@Entity
@Table(name = "t_question")
public class Question implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Quest quest;

    private String text;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @ToString.Exclude
    private final Collection<Answer> answers = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "game_state")
    private GameState gameState;

    @JsonIgnore
    public String getImage() {
        return "question-" + id;
    }
}
