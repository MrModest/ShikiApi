package ru.shikimori.api.models.title.anime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.enums.AnimeKind;
import ru.shikimori.api.models.Credential;
import ru.shikimori.api.models.title.TitleShort;

public class AnimeShort extends TitleShort {

    @SerializedName("episodes")
    @Expose
    private int episodes;

    @SerializedName("episodes_aired")
    @Expose
    private int episodesAired;

    //private AnimeShort(){}

    @Override
    public AnimeKind getKind(){
        return AnimeKind.fromString(this.kind);
    }

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

    public static AnimeShort getById(int id){
        return getById(id, null);
    }

    public static AnimeShort getById(int id, Credential credential){
        AnimeShort[] result = Anime.newSearch().whereIds(id).getResult(credential);
        return (result != null && result.length > 0) ? result[0] : null;
    }

    public static AnimeShort toConvert(Anime anime){
        if (anime == null) return null;

        AnimeShort animeShort = new AnimeShort();

        animeShort.id = anime.getId();
        animeShort.name = anime.getName();
        animeShort.russian = anime.getRussian();
        animeShort.image = anime.getImage();
        animeShort.url = anime.getUrl();
        animeShort.kind = anime.getKind().name();
        animeShort.releaseStatus = anime.getReleaseStatus().name();
        animeShort.airedDate = anime.getAiredDate().toString();
        animeShort.releasedDate = anime.getReleasedDate().toString();

        animeShort.episodes = anime.getEpisodes();
        animeShort.episodesAired = anime.getEpisodesAired();

        return animeShort;
    }

    public static AnimeShort[] toConvert(Anime[] animes){
        if (animes == null || animes.length == 0) return null;

        AnimeShort[] animeShorts = new AnimeShort[animes.length];
        for (int i = 0; i < animes.length; i++){
            animeShorts[i] = AnimeShort.toConvert(animes[i]);
        }

        return animeShorts;
    }
}
