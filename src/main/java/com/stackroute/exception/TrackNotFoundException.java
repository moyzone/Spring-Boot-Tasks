package com.stackroute.exception;

public class TrackNotFoundException extends Exception {
    private String message;

    public TrackNotFoundException(){}

    public TrackNotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
