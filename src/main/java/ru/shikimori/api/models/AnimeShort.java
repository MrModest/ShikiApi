package ru.shikimori.api.models;

import ru.shikimori.api.models.json._AnimeShortInfo;
import ru.shikimori.api.utils.DateUtils;

public class AnimeShort extends TitleShort {

    private int episodes;
    private int episodesAired;

    private AnimeShort(){}

    public int getEpisodes() {
        return episodes;
    }

    public int getEpisodesAired() {
        return episodesAired;
    }

    public Anime getFullInfo(){
        return Anime.getById(this.id);
    }

    public Anime getFullInfo(Credential credential){
        return Anime.getById(this.id, credential);
    }

    /*public static AnimeShort[] searchByFilter(AnimeFilter filter){
        String url = "animes?";

    }*/

    public static AnimeShort convertFromJsonModel(_AnimeShortInfo _animeShort){
        if (_animeShort == null) { return null; }

        AnimeShort animeShort = new AnimeShort();
        animeShort.id = _animeShort.id;
        animeShort.name = _animeShort.name;
        animeShort.russian = _animeShort.russian;
        animeShort.image = _animeShort.image;
        animeShort.url = _animeShort.url;
        animeShort.kind = _animeShort.kind;
        animeShort.status = _animeShort.status;
        animeShort.airedDate = DateUtils.formatDateFromString(_animeShort.aired_on);
        animeShort.releasedDate = DateUtils.formatDateFromString(_animeShort.released_on);

        animeShort.episodes = _animeShort.episodes;
        animeShort.episodesAired = _animeShort.episodes_aired;

        return animeShort;
    }

    public static AnimeShort[] convertFromJsonModel(_AnimeShortInfo[] _titleShorts){
        if (_titleShorts == null || _titleShorts.length == 0) { return null; }

        AnimeShort[] titleShort = new AnimeShort[_titleShorts.length];
        for (int i = 0; i < _titleShorts.length; i++){
            titleShort[i] = AnimeShort.convertFromJsonModel(_titleShorts[i]);
        }

        return titleShort;
    }
}
