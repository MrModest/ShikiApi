package ru.shikimori.api.models.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message){
        super(message);
    }

}
