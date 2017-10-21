package ru.shikimori.api.constants.enums;

import ru.shikimori.api.constants.TitleKind;
import ru.shikimori.api.models.filter.Filterable;

public enum AnimeKind implements Filterable {
    TV(TitleKind.Anime.TV),
    TV_SHORT(TitleKind.Anime.TV_SHORT),
    TV_AVERAGE(TitleKind.Anime.TV_AVERAGE),
    TV_LONG(TitleKind.Anime.TV_LONG),
    MOVIE(TitleKind.Anime.MOVIE),
    OVA(TitleKind.Anime.OVA),
    ONA(TitleKind.Anime.ONA),
    SPECIAL(TitleKind.Anime.SPECIAL),
    MUSIC(TitleKind.Anime.MUSIC)
    ;

    private final String filter_name;

    private AnimeKind(String filter_name){
        this.filter_name = filter_name;
    }

    @Override
    public String getFilterData() {
        return this.filter_name;
    }

    public static AnimeKind fromString(String kind){
        switch (kind){
            case TitleKind.Anime.TV: return AnimeKind.TV;
            case TitleKind.Anime.TV_SHORT: return AnimeKind.TV_SHORT;
            case TitleKind.Anime.TV_AVERAGE: return AnimeKind.TV_AVERAGE;
            case TitleKind.Anime.TV_LONG: return AnimeKind.TV_LONG;
            case TitleKind.Anime.MOVIE: return AnimeKind.MOVIE;
            case TitleKind.Anime.OVA: return AnimeKind.OVA;
            case TitleKind.Anime.ONA: return AnimeKind.ONA;
            case TitleKind.Anime.SPECIAL: return AnimeKind.SPECIAL;
            case TitleKind.Anime.MUSIC: return AnimeKind.MUSIC;
            default: return null;
        }
    }
}
