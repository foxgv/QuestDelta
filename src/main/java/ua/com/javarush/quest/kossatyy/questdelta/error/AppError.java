package ua.com.javarush.quest.kossatyy.questdelta.error;

public class AppError extends RuntimeException{
    public AppError() {
        super();
    }

    public AppError(String message) {
        super(message);
    }

    public AppError(String message, Throwable cause) {
        super(message, cause);
    }

    public AppError(Throwable cause) {
        super(cause);
    }

    protected AppError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
