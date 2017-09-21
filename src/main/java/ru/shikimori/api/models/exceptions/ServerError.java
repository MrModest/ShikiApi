package ru.shikimori.api.models.exceptions;

import ru.shikimori.api.models.json.error._Error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerError {

    private String url;
    private _Error error;
    private Date date;

    public ServerError(_Error error, Date date){
        this.error = error;
        this.date = date;
    }

    public ServerError(String url, _Error error, Date date){
        this.url = url;
        this.error = error;
        this.date = date;
    }

    public _Error getError() {
        return error;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date) + " | url: " + url + " | code: " + error.code + " | message: " + error.message;
    }
}
