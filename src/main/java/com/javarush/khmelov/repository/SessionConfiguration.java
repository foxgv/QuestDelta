package com.javarush.khmelov.repository;


import com.javarush.khmelov.entity.*;
import org.hibernate.cfg.Configuration;

public class SessionConfiguration extends Configuration {
    public SessionConfiguration() {
        LiquibaseChecker.updateDataBase(this);
        configure();
        addAnnotatedClass(Game.class);
        addAnnotatedClass(Answer.class);
        addAnnotatedClass(Question.class);
        addAnnotatedClass(Quest.class);
        addAnnotatedClass(User.class);
        addAnnotatedClass(UserInfo.class);
    }
}
