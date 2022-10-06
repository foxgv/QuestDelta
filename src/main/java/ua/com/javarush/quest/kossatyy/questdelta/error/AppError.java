package ua.com.javarush.quest.kossatyy.questdelta.error;

public class AppError extends RuntimeException {

    public AppError(String message) {
        super(message);
    }

    public AppError(String message, Throwable cause) {
        super(message, cause);
    }
}
