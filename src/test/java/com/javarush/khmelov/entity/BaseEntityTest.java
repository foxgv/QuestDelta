package com.javarush.khmelov.entity;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.repository.Container;
import com.javarush.khmelov.repository.SessionCreator;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;

public class BaseEntityTest {
    protected static Session session;
    protected static SessionCreator sessionCreator;

    @BeforeAll
    static void setUp() {
        Container.init();
        sessionCreator = Winter.getBean(SessionCreator.class);
        session = sessionCreator.get();
    }

}
