package ru.shikimori.api.models.userRate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.models.title.anime.AnimeShort;
import ru.shikimori.api.models.title.manga.MangaShort;
import ru.shikimori.api.models.user.UserShort;

public class UserRate extends UserRateShort {

    @SerializedName("user")
    @Expose
    private UserShort user;

    @SerializedName("anime")
    @Expose
    private AnimeShort anime;

    @SerializedName("manga")
    @Expose
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

}
