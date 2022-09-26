package ua.com.javarush.quest.kossatyy.questdelta.utils;

public enum Attribute {
    ERROR("error"),
    USER("user"),
    ROLE("role"),
    USERS("users"),
    COUNT_USERS("countUsers");

    private final String name;

    Attribute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
