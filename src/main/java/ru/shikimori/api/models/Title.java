package ru.shikimori.api.models;

import ru.shikimori.api.constants.TitleProgressStatus;
import ru.shikimori.api.models.json._NameValueClass;
import ru.shikimori.api.models.json._TitleFullInfo;

public class Title extends TitleShort {

    private String[] englishNames;
    private String[] japanesNames;
    private String[] synonymNames;
    private double score;
    private String description;
    private String descriptionHtml;
    private String descriptionSource; // (?)
    private boolean favoured;
    private boolean anons;
    private boolean ongoing;
    private int threadId;
    private int topicId;
    private int myanimelistId;
    private _NameValueClass[] ratesScoresStats;
    private _NameValueClass[] ratesStatusesStats;
    private Genre[] genres;
    private UserRateShort userRate;

    public Title(_TitleFullInfo _title){
        if (_title == null) { return; }
        this.englishNames = _title.english;
        this.japanesNames = _title.japanes;
        this.synonymNames = _title.synonyms;
        this.score = _title.score;
        this.description = _title.description;
        this.descriptionHtml = _title.description_html;
        this.descriptionSource = _title.description_source;
        this.favoured = _title.favoured;
        this.anons = _title.anons;
        this.ongoing = _title.ongoing;
        this.threadId = _title.thread_id;
        this.topicId = _title.topic_id;
        this.myanimelistId = _title.myanimelist_id;
        this.ratesScoresStats = _title.rates_scores_stats;
        this.ratesStatusesStats = _title.rates_statuses_stats;
        for (int i = 0; i < _title.genres.length; i++) { this.getGenres()[i] = new Genre(_title.genres[i]); }
        this.userRate = new UserRateShort(_title.user_rate);
    }

    public String[] getEnglishNames() {
        return englishNames;
    }

    public String[] getJapanesNames() {
        return japanesNames;
    }

    public String[] getSynonymNames() {
        return synonymNames;
    }

    public double getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public String getDescriptionSource() {
        return descriptionSource;
    }

    public boolean isFavoured() {
        return favoured;
    }

    public boolean isAnons() {
        return anons;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public int getThreadId() {
        return threadId;
    }

    public int getTopicId() {
        return topicId;
    }

    public int getMyanimelistId() {
        return myanimelistId;
    }

    public int getRatesScoresStats(Integer score) {
        for (int i = 0; i < ratesScoresStats.length; i++){
            if (ratesScoresStats[i].name.equalsIgnoreCase(score.toString())){
                return ratesScoresStats[i].value;
            }
        }

        return 0;
    }

    public int getRatesStatusesStats(int statusId) {
        for (int i = 0; i < ratesScoresStats.length; i++){
            if (ratesStatusesStats[i].name.equalsIgnoreCase(TitleProgressStatus.convertIdToRusName(statusId, "Anime")) ||
                ratesStatusesStats[i].name.equalsIgnoreCase(TitleProgressStatus.convertIdToRusName(statusId, "Manga"))){
                return ratesStatusesStats[i].value;
            }
        }

        return 0;
    }

    public int getRatesStatusesStats(String status) {
        return getRatesStatusesStats(TitleProgressStatus.convertNameToId(status));
    }

    public int getRatesStatusesStats(String statusOnRusLang, boolean rusLang) {
        for (int i = 0; i < ratesScoresStats.length; i++){
            if (ratesStatusesStats[i].name.equalsIgnoreCase(statusOnRusLang)){
                return ratesStatusesStats[i].value;
            }
        }

        return 0;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public UserRateShort getUserRate() {
        return userRate;
    }
}
