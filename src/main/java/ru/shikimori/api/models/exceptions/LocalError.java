package ru.shikimori.api.models.exceptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalError {

    private String methodName;
    private String error;
    private Date date;

    public LocalError(String methodName, String error, Date date){
        this.methodName = methodName;
        this.error = error;
        this.date = date;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getError() {
        return error;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date) + " | " + methodName + ": " + error;
    }
}
