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
}
