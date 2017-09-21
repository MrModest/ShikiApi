package ru.shikimori.api.models;

import ru.shikimori.api.models.json._UserRateShort;

public class UserRateShort {

    private int id;
    private int score;
    private String status;
    private String text;
    private Integer episodes; // possible null
    private Integer chapters; // possible null
    private Integer volumes;  // possible null
    private String textHtml;
    private Integer rewatches; // possible null

    public UserRateShort() {}

    public UserRateShort(_UserRateShort _userRateShort){
        if (_userRateShort == null) { return; }
        this.id = _userRateShort.id;
        this.score = _userRateShort.score;
        this.status = _userRateShort.status;
        this.text = _userRateShort.text;
        this.episodes = _userRateShort.episodes;
        this.chapters = _userRateShort.chapters;
        this.volumes = _userRateShort.volumes;
        this.textHtml = _userRateShort.text_html;
        this.rewatches = _userRateShort.rewatches;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public Integer getChapters() {
        return chapters;
    }

    public Integer getVolumes() {
        return volumes;
    }

    public String getTextHtml() {
        return textHtml;
    }

    public Integer getRewatches() {
        return rewatches;
    }
}
