package ua.com.javarush.quest.khmelov.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Getter
@Setter
@ToString

@Entity
@Table(name = "t_game")
public class Game implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "quest_id")
    private Long questId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "current_question_id")
    private Long currentQuestionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "game_state")
    private GameState gameState;

}
