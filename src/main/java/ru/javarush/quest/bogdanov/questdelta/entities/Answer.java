package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.concurrent.atomic.AtomicLong;

public class Answer {

    private static final AtomicLong ID_ANSWER_COUNTER = new AtomicLong(1);

    public long id;

    public long nextQuestionId;

}
