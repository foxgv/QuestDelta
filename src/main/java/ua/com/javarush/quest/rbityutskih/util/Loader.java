package ua.com.javarush.quest.rbityutskih.util;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class Loader implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public Loader() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Runner.load();
    }

}
