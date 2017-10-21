package ru.shikimori.api;

import ru.shikimori.api.constants.enums.MangaKind;
import ru.shikimori.api.models.*;
import ru.shikimori.api.models.exceptions.ErrorStack;
import ru.shikimori.api.models.title.anime.Anime;
import ru.shikimori.api.models.title.anime.AnimeShort;
import ru.shikimori.api.models.title.manga.Manga;
import ru.shikimori.api.models.title.manga.MangaShort;


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
            //Manga manga = Manga.getById(26, credential);
            //System.out.println(manga.getName());
            //User user = User.getById(4114);
            //System.out.println(user.getLastOnline());
            AnimeShort[] animeShorts = Anime.newSearch()
                    .releaseStatus(ru.shikimori.api.constants.enums.TitleReleaseStatus.ongoing, true)
                    .getResult();
            MangaShort[] mangaShorts = Manga.newSearch()
                    .releaseStatus(ru.shikimori.api.constants.enums.TitleReleaseStatus.ongoing, true)
                    .getResult();
            MangaKind mangaKind = mangaShorts[0].getKind();
            System.out.println(mangaKind);


        }
        //*/

        //outString = new User(12).getNickname();
        //System.out.println(UserRate.getUserRatesByUserId(4114).length);
        //System.out.println(User.getUserRatesById(4114, TitleType.Anime).length);

        System.out.println(outString);
    }
}