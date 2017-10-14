package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.TitleProgressStatus;
import ru.shikimori.api.models.json._NameValueClass;

public abstract class Title extends TitleShort {

    @SerializedName("english")
    @Expose
    protected String[] englishNames;

    @SerializedName("japanes")
    @Expose
    protected String[] japanesNames;

    @SerializedName("synonyms")
    @Expose
    protected String[] otherNames;

    @SerializedName("score")
    @Expose
    protected double score;

    @SerializedName("description")
    @Expose
    protected String description;

    @SerializedName("description_html")
    @Expose
    protected String descriptionHtml;

    @SerializedName("description_source")
    @Expose
    protected String descriptionSource; // (?)

    @SerializedName("favoured")
    @Expose
    protected boolean favoured;

    @SerializedName("anons")
    @Expose
    protected boolean anons;

    @SerializedName("ongoing")
    @Expose
    protected boolean ongoing;

    @SerializedName("thread_id")
    @Expose
    protected int threadId;

    @SerializedName("topic_id")
    @Expose
    protected int topicId;

    @SerializedName("myanimelist_id")
    @Expose
    protected int myanimelistId;

    @SerializedName("rates_scores_stats")
    @Expose
    protected _NameValueClass[] ratesScoresStats;

    @SerializedName("rates_statuses_stats")
    @Expose
    protected _NameValueClass[] ratesStatusesStats;

    @SerializedName("genres")
    @Expose
    protected Genre[] genres;

    @SerializedName("user_rate")
    @Expose
    protected UserRateShort userRate;

    protected Title() {}

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
