package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MangaShort extends TitleShort {

    @SerializedName("volumes")
    @Expose
    private int volumes;

    @SerializedName("chapters")
    @Expose
    private int chapters;

    private MangaShort(){}

    public int getVolumes() {
        return volumes;
    }

    public int getChapters() {
        return chapters;
    }

    public Manga getFullInfo(){
        return Manga.getById(this.id);
    }

    public Manga getFullInfo(Credential credential){
        return Manga.getById(this.id, credential);
    }

}
