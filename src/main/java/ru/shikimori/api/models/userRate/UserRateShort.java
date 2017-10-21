package ru.shikimori.api.models.userRate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.requests.QueryShell;

public class UserRateShort {

    @SerializedName("id")
    @Expose
    protected int id;

    @SerializedName("score")
    @Expose
    protected int score;

    @SerializedName("releaseStatus")
    @Expose
    protected String status;

    @SerializedName("text")
    @Expose
    protected String text;

    @SerializedName("episodes")
    @Expose
    protected Integer episodes; // possible null

    @SerializedName("chapters")
    @Expose
    protected Integer chapters; // possible null

    @SerializedName("volumes")
    @Expose
    protected Integer volumes;  // possible null

    @SerializedName("text_html")
    @Expose
    protected String textHtml;

    @SerializedName("rewatches")
    @Expose
    protected Integer rewatches; // possible null

    protected UserRateShort() {}

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
        return QueryShell.get("v2/user_rates/" + id, UserRateV2.class);
    }

    public static UserRateV2[] getUserRatesByUserId(int user_id){
        return QueryShell.get("v2/user_rates?user_id=" + user_id, UserRateV2[].class);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;

        try {
            UserRateShort otherTitleShort = (UserRateShort) other;
            return this.id == otherTitleShort.id;
        }
        catch (Exception ex){
            return false;
        }
    }

}
