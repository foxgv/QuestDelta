package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.concurrent.atomic.AtomicLong;

public class Game {

    private static final AtomicLong ID_GAME_COUNTER = new AtomicLong(1);

    public long id;

    public long userId;

    public long questId;

    public long currentQuestionId;

    public GameState gameState;

    public Game(long userId, long questId) {
        this.id = ID_GAME_COUNTER.getAndIncrement();
        this.userId = userId;
        this.questId = questId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuestId() {
        return questId;
    }

    public long getCurrentQuestionId() {
        return currentQuestionId;
    }

    public GameState getGameState() {
        return gameState;
    }

    @Override
    public String toString() {
        return "Game{" +
                "userId=" + userId +
                ", questId=" + questId +
                ", gameState=" + gameState +
                '}';
    }
}
