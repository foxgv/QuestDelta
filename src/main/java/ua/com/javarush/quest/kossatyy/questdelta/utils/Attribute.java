package ua.com.javarush.quest.kossatyy.questdelta.utils;

public enum Attribute {
    COUNT_USERS("count"),
    ERROR("error"),
    GAME_ID("gameId"),
    GAME("game"),
    GAME_SESSION("gameSession"),
    GAMES("games"),
    ID("id"),
    LEVEL("level"),
    LOGIN("login"),
    LOGIN_NEW("loginNew"),
    PAGE_COUNT("pageCount"),
    PAGE_NUMBER("page"),
    PAGE_SIZE("size"),
    PASSWORD("password"),
    ROLE("role"),
    USER("user"),
    USER_UPDATE("userUpdate"),
    USERS("users"),
    BUTTON("button");


    private final String value;

    Attribute(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
