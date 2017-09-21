package ru.shikimori.api.models.exceptions;

import org.omg.CORBA.Environment;
import ru.shikimori.api.models.json.error._Error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorStack {

    private ErrorStack(){}

    private static List<ServerError> serverErrors = new ArrayList<>();
    private static List<LocalError> localErrors = new ArrayList<>();
    private static boolean debug = false;

    public static List<ServerError> getServerErrors() {
        return serverErrors;
    }

    public static List<LocalError> getLocalErrors() {
        return localErrors;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        ErrorStack.debug = debug;
    }

    public static void PushServerError(_Error serverError){
        Date dateNow = new Date();
        ServerError _error = new ServerError(serverError, dateNow);
        serverErrors.add(_error);
        if (debug){ System.out.println(_error.toString()); }
    }

    public static void PushServerError(String url, _Error serverError){
        Date dateNow = new Date();
        ServerError _error = new ServerError(url, serverError, dateNow);
        serverErrors.add(_error);
        if (debug){ System.out.println(_error.toString()); }
    }

    public static void PushServerError(String url, int code, String message){
        Date dateNow = new Date();
        ServerError _error = new ServerError(url, new _Error(code, message), dateNow);
        serverErrors.add(_error);
        if (debug){ System.out.println(_error.toString()); }
    }

    public static void PushLocalError(String methodName, String error){
        Date dateNow = new Date();
        LocalError _error = new LocalError(methodName, error, dateNow);
        localErrors.add(_error);
        if (debug){ System.out.println(_error.toString()); }
    }

    public static ServerError PopServerError(){
        if (serverErrors == null || serverErrors.isEmpty()) { return null; }
        return serverErrors.get(serverErrors.size() - 1);
    }

    public static LocalError PopLocalError(){
        if (localErrors == null || localErrors.isEmpty()) { return null; }
        return localErrors.get(localErrors.size() - 1);
    }

    public static void PrintAllServerError(){
        System.out.println();
        for(ServerError serverError : serverErrors){
            System.out.println(serverError.toString() + '\n');
        }
        System.out.println();
    }

    public static void PrintAllLocalError(){
        System.out.println();
        for(LocalError localError : localErrors){
            System.out.println(localError.toString() + '\n');
        }
        System.out.println();
    }
}
