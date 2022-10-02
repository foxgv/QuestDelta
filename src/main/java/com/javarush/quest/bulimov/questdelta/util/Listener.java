package com.javarush.quest.bulimov.questdelta.util;

import com.javarush.quest.bulimov.questdelta.util.RepositoryLoader;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public Listener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        RepositoryLoader.load();/* This method is called when the servlet context is initialized(when the Web application is deployed). */
    }

}
