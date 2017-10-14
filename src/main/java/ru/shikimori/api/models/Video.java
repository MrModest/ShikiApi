package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("player_url")
    @Expose
    private String playerUrl;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("hosting")
    @Expose
    private String hosting;

    private Video(){}

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public String getHosting() {
        return hosting;
    }

}
