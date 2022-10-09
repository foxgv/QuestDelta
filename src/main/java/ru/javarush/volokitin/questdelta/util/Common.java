package ru.javarush.volokitin.questdelta.util;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public class Common {

    public static Optional<String> getRequestParameter(HttpServletRequest req, String name) {
        return Optional.ofNullable(req.getParameter(name));
    }

    public static String getSessionAttribute(HttpServletRequest req, String name) {
        return req.getSession().getAttribute(name).toString();
    }
}
