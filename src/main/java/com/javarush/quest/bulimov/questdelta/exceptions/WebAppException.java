package com.javarush.quest.bulimov.questdelta.exceptions;

public class WebAppException extends RuntimeException{
    public WebAppException(String message) {
        super(message);
    }

    public WebAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
