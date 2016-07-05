package com.example.vaadin.calculejter.exception;

/**
 * Created by Błażej on 04.07.2016.
 */
public class BadValuesException extends Exception {

    public BadValuesException() {
    }

    public BadValuesException(String message) {
        super(message);
    }

    public BadValuesException(String message, Throwable cause) {
        super(message, cause);
    }
}

