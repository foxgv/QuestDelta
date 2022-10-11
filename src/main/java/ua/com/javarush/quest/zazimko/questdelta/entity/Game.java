package ua.com.javarush.quest.zazimko.questdelta.entity;

import lombok.Builder;

import java.util.Objects;

@Builder(builderMethodName = "with")
public class Game {
    Long id;
    Long questId;
    Long userId;
    Long currentQuestionId;
    GameState gameState;

    public Game(Long id, Long questId, Long userId, Long currentQuestionId, GameState gameState) {
        this.id = id;
        this.questId = questId;
        this.userId = userId;
        this.currentQuestionId = currentQuestionId;
        this.gameState = gameState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestId() {
        return questId;
    }

    public void setQuestId(Long questId) {
        this.questId = questId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCurrentQuestionId() {
        return currentQuestionId;
    }

    public void setCurrentQuestionId(Long currentQuestionId) {
        this.currentQuestionId = currentQuestionId;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(questId, game.questId) && Objects.equals(userId, game.userId) && Objects.equals(currentQuestionId, game.currentQuestionId) && gameState == game.gameState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questId, userId, currentQuestionId, gameState);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", questId=" + questId +
                ", userId=" + userId +
                ", currentQuestionId=" + currentQuestionId +
                ", gameState=" + gameState +
                '}';
    }
}
