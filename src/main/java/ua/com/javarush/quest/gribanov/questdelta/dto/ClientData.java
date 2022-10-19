package ua.com.javarush.quest.gribanov.questdelta.dto;

import ua.com.javarush.quest.gribanov.questdelta.entity.AbstractEntity;

import java.util.Map;

public class ClientData<E extends AbstractEntity> {
    private E template;
    private Map<String, String[]> parameters;

    public ClientData(E template, Map<String, String[]> parameters) {
        this.template = template;
        this.parameters = parameters;
    }

    public String getParameter(String name) {
        return parameters.getOrDefault(name, new String[1])[0];
    }

    public Long getId() {
        return parameters.containsKey("id")
                ? Long.valueOf(getParameter("id"))
                : null;
    }
}
