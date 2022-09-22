package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.concurrent.atomic.AtomicLong;

public class Game {

    private static final AtomicLong ID_GAME_COUNTER = new AtomicLong(1);

    public long id;

    User user;

}
