package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Question {

    private static final AtomicLong ID_QUESTION_COUNTER = new AtomicLong(1);

    public long id;

    List<Answer> answerList;

    Long questId;

}
