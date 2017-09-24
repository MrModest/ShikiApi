package ru.shikimori.api.models;

import ru.shikimori.api.models.json._UserRateShort;
import ru.shikimori.api.models.json._UserRateV2;
import ru.shikimori.api.requests.QueryShell;

public class UserRateShort {

    protected int id;
    protected int score;
    protected String status;
    protected String text;
    protected Integer episodes; // possible null
    protected Integer chapters; // possible null
    protected Integer volumes;  // possible null
    protected String textHtml;
    protected Integer rewatches; // possible null

    protected UserRateShort() {}

    /*public UserRateShort(_UserRateShort _userRateShort){
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
    }*/

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

    public static UserRateV2 getById(int id){
        return UserRateV2.convertFromJsonModel(QueryShell.get("v2/user_rates/" + id, _UserRateV2.class));
    }

    public static UserRateV2[] getUserRatesByUserId(int user_id){
        return UserRateV2.convertFromJsonModel(QueryShell.get("v2/user_rates?user_id=" + user_id, _UserRateV2[].class));
    }

    public static UserRateShort convertFromJsonModel(_UserRateShort _userRateShort){
        if (_userRateShort == null) { return null; }

        UserRateShort userRateShort = new UserRateShort();
        userRateShort.id = _userRateShort.id;
        userRateShort.score = _userRateShort.score;
        userRateShort.status = _userRateShort.status;
        userRateShort.text = _userRateShort.text;
        userRateShort.episodes = _userRateShort.episodes;
        userRateShort.chapters = _userRateShort.chapters;
        userRateShort.volumes = _userRateShort.volumes;
        userRateShort.textHtml = _userRateShort.text_html;
        userRateShort.rewatches = _userRateShort.rewatches;

        return userRateShort;
    }

    public static UserRateShort[] convertFromJsonModel(_UserRateShort[] _userRatesShort){
        if (_userRatesShort == null || _userRatesShort.length == 0) { return null; }

        UserRateShort[] userRatesShort = new UserRateShort[_userRatesShort.length];
        for (int i = 0; i < _userRatesShort.length; i++){
            userRatesShort[i] = UserRateShort.convertFromJsonModel(_userRatesShort[i]);
        }

        return userRatesShort;
    }

}
