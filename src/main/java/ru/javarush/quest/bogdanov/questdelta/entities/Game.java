package ru.javarush.quest.bogdanov.questdelta.entities;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Game {

    private static final AtomicLong ID_GAME_COUNTER = new AtomicLong(1);

    public long id;

    public long userId;

    public long questId;

    public long currentQuestionId;

    public GameState gameState;

    public LocalDate date;

    public Game(long userId, long questId) {
        this.id = ID_GAME_COUNTER.getAndIncrement();
        this.userId = userId;
        this.questId = questId;
        this.date = LocalDate.now();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Game{" +
                "userId=" + userId +
                ", gameState=" + gameState +
                ", date=" + date +
                '}';
    }
}
