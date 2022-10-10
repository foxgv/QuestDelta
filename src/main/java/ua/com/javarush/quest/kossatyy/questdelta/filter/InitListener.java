package ua.com.javarush.quest.kossatyy.questdelta.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.kossatyy.questdelta.config.Init;

@WebListener
public class InitListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Init.load();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //TODO save all repository before destroy
    }
}
