package ua.com.javarush.quest.kossatyy.questdelta.utils;

public enum Attribute {
    ERROR("error"),
    USER("user"),
    ROLE("role"),
    USERS("users"),
    COUNT_USERS("count"),
    PAGE_COUNT("pageCount"),
    PAGE_NUMBER("page"),
    PAGE_SIZE("size");


    private final String value;

    Attribute(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
