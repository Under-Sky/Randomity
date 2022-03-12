package ru.itlab.server.util.exception;

public class EmailIsAlreadyExistException extends Throwable{
    public EmailIsAlreadyExistException() {
        super();
    }

    public EmailIsAlreadyExistException(String message) {
        super(message);
    }
}
