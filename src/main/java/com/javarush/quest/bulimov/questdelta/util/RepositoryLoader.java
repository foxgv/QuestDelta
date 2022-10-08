package com.javarush.quest.bulimov.questdelta.util;

import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.entity.Quest;
import com.javarush.quest.bulimov.questdelta.entity.Question;
import com.javarush.quest.bulimov.questdelta.repository.AnswerRepository;
import com.javarush.quest.bulimov.questdelta.repository.QuestRepository;
import com.javarush.quest.bulimov.questdelta.repository.QuestionRepository;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashSet;

@UtilityClass
public class RepositoryLoader {
    private final QuestRepository questRepository = QuestRepository.get();
    private final QuestionRepository questionRepository = QuestionRepository.get();
    private final AnswerRepository answerRepository = AnswerRepository.get();

    public void load() {
        defaultInit();
    }


    private static void defaultInit() {
        Quest questJavaRush = Quest.with()
                .name("JavaRushQuest")
                .authorId("Admin")
                .id(1L)
                .build();



        Question question1 = Question.with()
                .id(1L)
                .questId(1L)
                .text("Ты потерял память. Принять вызов НЛО?").build();

        Question question2 = Question.with()
                .id(2L)
                .questId(1L)
                .text("Ты принял вызов. Подняться на мостик к капитану?").build();

        Question question3 = Question.with()
                .id(3L)
                .questId(1L)
                .text("Ты поднялся на мостик. Ты кто?").build();


        Question question4 = Question.with()
                .id(4L)
                .questId(1L)
                .text("Тебя вернули домой! Победа!").build();


        Question question5 = Question.with()
                .id(5L)
                .questId(1L)
                .text("Ты отклонил вызов. Поражение.").build();

        Question question6 = Question.with()
                .id(6L)
                .questId(1L)
                .text("Ты не пошел на переговоры. Поражение.").build();

        Question question7 = Question.with()
                .id(7L)
                .questId(1L)
                .text("Твою ложь разоблачили. Поражение.").build();






        Answer answer1 = Answer.with()
                .questionId(1L)
                .id(1L)
                .text("Принять вызов")
                .nextQuestionId(2L).build();
        Answer answer2 = Answer.with()
                .questionId(1L)
                .id(2L)
                .correct(false)
                .nextQuestionId(5L)
                .text("Отклонить вызов").build();


        Answer answer3 = Answer.with()
                .questionId(2L)
                .id(3L)
                .text("Подняться на мостик")
                .nextQuestionId(3L).build();
        Answer answer4 = Answer.with()
                .questionId(2L)
                .id(4L)
                .correct(false)
                .nextQuestionId(6L)
                .text("Отказаться подниматься на мостик").build();


        Answer answer5 = Answer.with()
                .questionId(3L)
                .id(5L)
                .text("Рассказать правду")
                .nextQuestionId(4L).build();
        Answer answer6 = Answer.with()
                .questionId(3L)
                .id(6L)
                .correct(false)
                .nextQuestionId(7L)
                .text("Солгать о себе").build();

        question1.setAnswers(new HashSet<>());
        question1.getAnswers().add(answer1);
        question1.getAnswers().add(answer2);

        question2.setAnswers(new HashSet<>());
        question2.getAnswers().add(answer3);
        question2.getAnswers().add(answer4);

        question3.setAnswers(new HashSet<>());
        question3.getAnswers().add(answer5);
        question3.getAnswers().add(answer6);


        questJavaRush.setQuestions(new HashSet<>());
        questJavaRush.getQuestions().add(question1);
        questJavaRush.getQuestions().add(question2);
        questJavaRush.getQuestions().add(question3);
        questJavaRush.getQuestions().add(question4);
        questJavaRush.getQuestions().add(question5);
        questJavaRush.getQuestions().add(question6);
        questJavaRush.getQuestions().add(question7);



        questRepository.update(questJavaRush);

        questionRepository.update(question1);
        questionRepository.update(question2);
        questionRepository.update(question3);
        questionRepository.update(question4);
        questionRepository.update(question5);
        questionRepository.update(question6);
        questionRepository.update(question7);

        answerRepository.update(answer1);
        answerRepository.update(answer2);
        answerRepository.update(answer3);
        answerRepository.update(answer4);
        answerRepository.update(answer5);
        answerRepository.update(answer6);

    }



}
