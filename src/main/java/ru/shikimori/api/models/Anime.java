package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;
import ru.shikimori.api.requests.QueryShell;
import ru.shikimori.api.utils.DateUtils;

import java.time.LocalDateTime;

public class Anime extends Title {

    @SerializedName("episodes")
    @Expose
    private int episodes;

    @SerializedName("episodes_aired")
    @Expose
    private int episodesAired;

    @SerializedName("rating")
    @Expose
    private String rating;

    @SerializedName("duration")
    @Expose
    private int duration;

    @SerializedName("updated_at")
    @Expose
    private String updatedDateTime;

    @SerializedName("next_episode_at")
    @Expose
    private String nextEpisodeDateTime;

    @SerializedName("studios")
    @Expose
    private Studio[] studios;

    @SerializedName("videos")
    @Expose
    private Video[] videos;

    @SerializedName("screenshots")
    @Expose
    private TitleScreenshot[] screenshots;

    private Anime(){}

    public int getEpisodes() {
        return episodes;
    }

    public int getEpisodesAired() {
        return episodesAired;
    }

    public String getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getUpdatedDateTime() {
        return DateUtils.formatDateTimeFromString(updatedDateTime);
    }

    public LocalDateTime getNextEpisodeDateTime() {
        return DateUtils.formatDateTimeFromString(nextEpisodeDateTime);
    }

    public Studio[] getStudios() {
        return studios;
    }

    public Video[] getVideos() {
        return videos;
    }

    public TitleScreenshot[] getScreenshots() {
        return screenshots;
    }


    public static Anime getById(int titleId){
        if (titleId < 1) { return null; }

        return QueryShell.get("animes/" + titleId, Anime.class);
    }

    public static Anime getById(int titleId, Credential credential){
        if (titleId < 1) { return null; }

        return QueryShell.get("animes/" + titleId, Anime.class, credential);
    }

    public static AnimeShort[] searchByFilter(AnimeFilter filter, Credential credential){ //WARNING!!!
        String url = "animes?";

        if (StringUtils.isNotBlank(filter.getSearchText())) { url += "search=" + filter.getSearchText(); }
        if (StringUtils.isNotBlank(filter.getOrder())) { url += "&order=" + filter.getOrder(); }

        return  (credential != null) ?
                QueryShell.get(url, AnimeShort[].class, credential) : QueryShell.get(url, AnimeShort[].class);
    }

    public static AnimeShort[] searchByFilter(AnimeFilter filter){
        return searchByFilter(filter, null);
    }

}
