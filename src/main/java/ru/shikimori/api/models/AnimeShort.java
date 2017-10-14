package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimeShort extends TitleShort {

    @SerializedName("episodes")
    @Expose
    private int episodes;

    @SerializedName("episodes_aired")
    @Expose
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

}
