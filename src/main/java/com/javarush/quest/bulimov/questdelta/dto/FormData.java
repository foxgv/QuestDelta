package com.javarush.quest.bulimov.questdelta.dto;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public class FormData {

    private final Map<String, String[]> parameterMap;

    public FormData(HttpServletRequest request) {
        this.parameterMap = request.getParameterMap();
    }

    public static FormData of(HttpServletRequest request){
        return new FormData(request);
    }

    public String getParameter(String name){
        return parameterMap.getOrDefault(name, new String[1])[0];
    }

    public Long getId() {
        return parameterMap.containsKey("id")
                ? Long.valueOf(getParameter("id"))
                : null;
    }
}
