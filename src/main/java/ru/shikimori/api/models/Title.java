package ru.shikimori.api.models;

import ru.shikimori.api.constants.TitleProgressStatus;
import ru.shikimori.api.models.json._NameValueClass;

public abstract class Title extends TitleShort {

    protected String[] englishNames;
    protected String[] japanesNames;
    protected String[] otherNames;
    protected double score;
    protected String description;
    protected String descriptionHtml;
    protected String descriptionSource; // (?)
    protected boolean favoured;
    protected boolean anons;
    protected boolean ongoing;
    protected int threadId;
    protected int topicId;
    protected int myanimelistId;
    protected _NameValueClass[] ratesScoresStats;
    protected _NameValueClass[] ratesStatusesStats;
    protected Genre[] genres;
    protected UserRateShort userRate;

    protected Title() {}

    /*public Title(_TitleFullInfo _title){
        super(_title);
        if (_title == null) { return; }
        this.englishNames = _title.english;
        this.japanesNames = _title.japanes;
        this.otherNames = _title.synonyms;
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
        for (int i = 0; i < _title.genres.length; i++) { this.getGenres()[i] = Genre.convertFromJsonModel(_title.genres[i]); }
        this.userRate = UserRateShort.convertFromJsonModel(_title.user_rate);
    }*/

    public String[] getEnglishNames() {
        return englishNames;
    }

    public String[] getJapanesNames() {
        return japanesNames;
    }

    public String[] getOtherNames() {
        return otherNames;
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

    public int getRatesScoresStats(int score) {
        for (int i = 0; i < ratesScoresStats.length; i++){
            if (ratesScoresStats[i].name.equalsIgnoreCase(new Integer(score).toString())){
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
