package ru.shikimori.api.models;

import ru.shikimori.api.models.json._Video;

public class Video {

    private int id;
    private String url;
    private String imageUrl;
    private String playerUrl;
    private String name;
    private String kind;
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

    public static Video convertFromJsonModel(_Video _video){
        if (_video == null) { return null; }

        Video video = new Video();
        video.id = _video.id;
        video.url = _video.url;
        video.imageUrl = _video.image_url;
        video.playerUrl = _video.player_url;
        video.name = _video.name;
        video.kind = _video.kind;
        video.hosting = _video.hosting;

        return video;
    }

    public static Video[] convertFromJsonModel(_Video[] _videos){
        if (_videos == null || _videos.length == 0) { return null; }

        Video[] videos = new Video[_videos.length];
        for (int i = 0; i < _videos.length; i++){
            videos[i] = Video.convertFromJsonModel(_videos[i]);
        }

        return videos;
    }

}
