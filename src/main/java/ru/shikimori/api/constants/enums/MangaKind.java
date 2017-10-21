package ru.shikimori.api.constants.enums;

import ru.shikimori.api.constants.TitleKind;
import ru.shikimori.api.models.filter.Filterable;

public enum MangaKind implements Filterable {
    MANGA(TitleKind.Manga.MANGA),
    MANHWA(TitleKind.Manga.MANHWA),
    MANHUA(TitleKind.Manga.MANHUA),
    NOVEL(TitleKind.Manga.NOVEL),
    ONE_SHOT(TitleKind.Manga.ONE_SHOT),
    DOUJIN(TitleKind.Manga.DOUJIN)
    ;

    private final String filter_name;

    private MangaKind(String filter_name){
        this.filter_name = filter_name;
    }

    @Override
    public String getFilterData() {
        return this.filter_name;
    }

    public static MangaKind fromString(String kind){
        switch (kind){
            case TitleKind.Manga.MANGA: return MangaKind.MANGA;
            case TitleKind.Manga.MANHWA: return MangaKind.MANHWA;
            case TitleKind.Manga.MANHUA: return MangaKind.MANHUA;
            case TitleKind.Manga.NOVEL: return MangaKind.NOVEL;
            case TitleKind.Manga.ONE_SHOT: return MangaKind.ONE_SHOT;
            case TitleKind.Manga.DOUJIN: return MangaKind.DOUJIN;
            default: return null;
        }
    }
}
