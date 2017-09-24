package ru.shikimori.api.models;

import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.models.json._UserRate;

public class UserRate extends UserRateShort {

    private UserShort user;
    private AnimeShort anime;
    private MangaShort manga;

    private UserRate(){}

    public UserShort getUser() {
        return user;
    }

    public AnimeShort getAnime() {
        return anime;
    }

    public MangaShort getManga() {
        return manga;
    }


    public boolean isAnime(){
        return anime != null;
    }

    public boolean isManga(){
        return manga != null;
    }

    public TitleType getTitleType(){
        if (isAnime()) { return TitleType.Anime; }
        if (isManga()) { return TitleType.Manga; }
        return null;
    }


    public static UserRate convertFromJsonModel(_UserRate _userRate){
        if (_userRate == null) { return null; }

        UserRate userRate = new UserRate();
        userRate.id = _userRate.id;
        userRate.score = _userRate.score;
        userRate.status = _userRate.status;
        userRate.text = _userRate.text;
        userRate.episodes = _userRate.episodes;
        userRate.chapters = _userRate.chapters;
        userRate.volumes = _userRate.volumes;
        userRate.textHtml = _userRate.text_html;
        userRate.rewatches = _userRate.rewatches;

        userRate.user = UserShort.convertFromJsonModel(_userRate.user);
        userRate.anime = AnimeShort.convertFromJsonModel(_userRate.anime);
        userRate.manga = MangaShort.convertFromJsonModel(_userRate.manga);

        return userRate;
    }

    public static UserRate[] convertFromJsonModel(_UserRate[] _userRates){
        if (_userRates == null || _userRates.length == 0) { return null; }

        UserRate[] userRates = new UserRate[_userRates.length];
        for (int i = 0; i < _userRates.length; i++){
            userRates[i] = UserRate.convertFromJsonModel(_userRates[i]);
        }

        return userRates;
    }
}
