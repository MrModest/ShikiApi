package ru.shikimori.api;

import ru.shikimori.api.constants.enums.TitleProgressStatus;
import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.models.*;
import ru.shikimori.api.models.exceptions.ErrorStack;


public class Main {

    public static void main(String[] args) {

        ErrorStack.setDebug(true);

        String outString = "";

        //*
        //Credential credential = new Credential("test2", "123");
        Credential credential = new Credential("MrModest", "kamil2322332");
        if (!credential.isLoginSuccess()){
            outString = "login failed!\n";
        }
        else {
            Manga manga = Manga.getById(26, credential);
            System.out.println(manga.getName());
            User user = User.getUserById(4114);
            System.out.println(user.getLastOnline());
        }
        //*/

        //outString = new User(12).getNickname();
        //System.out.println(UserRate.getUserRatesByUserId(4114).length);
        //System.out.println(User.getUserRatesById(4114, TitleType.Anime).length);

        String str = "substring";
        System.out.println(str.substring(0, str.length() - 1));

        System.out.println(outString);
    }
}