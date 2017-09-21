package ru.shikimori.api;

import ru.shikimori.api.models.Credential;
import ru.shikimori.api.models.User;
import ru.shikimori.api.models.UserShort;
import ru.shikimori.api.models.exceptions.ErrorStack;
import ru.shikimori.api.models.json._UserShortInfo;
import ru.shikimori.api.requests.QueryShell;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        ErrorStack.setDebug(true);

        String outString = "";

        //*
        Credential credential = new Credential("test2", "123");
        //Credential credential = new Credential("MrModest", "kamil2322332");
        if (!credential.isLoginSuccess()){
            outString = "login failed!\n";
        }
        else {
            for (int i = 4086; i < 4100; i++){
                long start = System.currentTimeMillis();
                try {
                    UserShort[] friends = User.getFriendsById(i);
                    long end = System.currentTimeMillis();
                    System.out.println("id: " + i + " | count: " + friends.length + " | ms: " + (end - start));
                }
                catch (NullPointerException ex){
                    System.out.println("User with id " + i + " not found.");
                }
            }
        }
        //*/

        //outString = new User(12).getNickname();

        System.out.println(outString);
    }
}