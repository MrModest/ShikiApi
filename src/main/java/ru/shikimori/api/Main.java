package ru.shikimori.api;

import ru.shikimori.api.constants.enums.TitleProgressStatus;
import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.models.*;
import ru.shikimori.api.models.exceptions.ErrorStack;


public class Main {

    public static void main(String[] args) {

        ErrorStack.setDebug(true);

        String outString = "";

        /*
        //Credential credential = new Credential("test2", "123");
        Credential credential = new Credential("MrModest", "kamil2322332");
        if (!credential.isLoginSuccess()){
            outString = "login failed!\n";
        }
        else {
            System.out.println(Anime.getById(25, credential).getNextEpisodeDateTime());
        }
        */

        //outString = new User(12).getNickname();
        //System.out.println(UserRate.getUserRatesByUserId(4114).length);
        //System.out.println(User.getUserRatesById(4114, TitleType.Anime).length);

        String str = "substring";
        System.out.println(str.substring(0, str.length() - 1));

        System.out.println(outString);
    }
}