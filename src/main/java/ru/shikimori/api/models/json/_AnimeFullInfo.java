package ru.shikimori.api.models.json;

public class _AnimeFullInfo extends _AnimeShortInfo {

    public String rating;
    public String[] english;
    public String[] japanes;
    public String[] synonyms;
    public int duration;
    public double score;
    public String description;
    public String description_html;
    public String description_source; // (?)
    public boolean favoured;
    public boolean anons;
    public boolean ongoing;
    public int thread_id;
    public int topic_id;
    public int myanimelist_id;
    public _NameValueClass[] rates_scores_stats;
    public _NameValueClass[] rates_statuses_stats;
    public String updated_at;
    public String next_episode_at;
    public _Genre[] genres;
    public _Studio[] studios;
    public _Video[] videos;
    public _TitleScreenshot[] screenshots;
    public _UserRateShort user_rate;

}
