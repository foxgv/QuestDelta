package com.javarush.khmelov.repository;

import com.javarush.khmelov.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.concurrent.atomic.AtomicInteger;


public class SessionCreator implements AutoCloseable {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final SessionFactory sessionFactory;
    private final AtomicInteger level = new AtomicInteger();

    public SessionCreator() {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = getSessionFactory(configuration);
    }

    /**
     * Constructor for testcontainers
     *
     * @param configuration - set special mode (for tests)
     */
    protected SessionCreator(Configuration configuration) {
        sessionFactory = getSessionFactory(configuration);
    }

    private SessionFactory getSessionFactory(Configuration configuration) {
        LiquibaseChecker.updateDataBase(configuration);
        configuration.addAnnotatedClass(Game.class);
        configuration.addAnnotatedClass(Answer.class);
        configuration.addAnnotatedClass(Question.class);
        configuration.addAnnotatedClass(Quest.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(UserInfo.class);
        return configuration.buildSessionFactory();
    }

    public Session get() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void close() {
        sessionFactory.close();
    }

    public void beginTransactional() {
        Session session = get();
        if (level.getAndIncrement() == 0) {
            session.beginTransaction();
        }
    }

    public void endTransactional() {
        Session session = get();
        if (level.decrementAndGet() == 0) {
            try {
                session.getTransaction().commit();
            } catch (RuntimeException e) {
                session.getTransaction().rollback();
                throw e;
            }
        } else {
            session.flush();
        }
    }
}
