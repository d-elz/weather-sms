package com.weatherapi.exceptions;

public class RouteeException extends Exception{

    public RouteeException(String msg, Throwable t) {
        super(msg, t);
    }

    public RouteeException(String msg) {
        super(msg);
    }
}
