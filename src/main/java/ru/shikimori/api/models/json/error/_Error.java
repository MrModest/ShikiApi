package ru.shikimori.api.models.json.error;

public class _Error {

    public int code;
    public String message;

    public _Error(){}

    public _Error(int code, String message){
        this.code = code;
        this.message = message;
    }

}
