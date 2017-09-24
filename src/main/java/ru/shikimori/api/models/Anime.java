package ru.shikimori.api.models;

import ru.shikimori.api.models.json._AnimeFullInfo;
import ru.shikimori.api.requests.QueryShell;
import ru.shikimori.api.utils.DateUtils;

import java.time.LocalDateTime;

public class Anime extends Title {

    private int episodes;
    private int episodesAired;
    private String rating;
    private int duration;
    private LocalDateTime updatedDateTime;
    private LocalDateTime nextEpisodeDateTime;
    private Studio[] studios;
    private Video[] videos;
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
        return updatedDateTime;
    }

    public LocalDateTime getNextEpisodeDateTime() {
        return nextEpisodeDateTime;
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

        return Anime.convertFromJsonModel(QueryShell.get("animes/" + titleId, _AnimeFullInfo.class));
    }

    public static Anime getById(int titleId, Credential credential){
        if (titleId < 1) { return null; }

        return Anime.convertFromJsonModel(QueryShell.get("animes/" + titleId, _AnimeFullInfo.class, credential));
    }



    public static Anime convertFromJsonModel(_AnimeFullInfo _title){
        if (_title == null) { return null; }

        Anime title = new Anime();
        title.id = _title.id;
        title.name = _title.name;
        title.russian = _title.russian;
        title.image = _title.image;
        title.url = _title.url;
        title.kind = _title.kind;
        title.status = _title.status;
        title.airedDate = DateUtils.formatDateFromString(_title.aired_on);
        title.releasedDate = DateUtils.formatDateFromString(_title.released_on);

        title.englishNames = _title.english;
        title.japanesNames = _title.japanes;
        title.otherNames = _title.synonyms;
        title.score = _title.score;
        title.description = _title.description;
        title.descriptionHtml = _title.description_html;
        title.descriptionSource = _title.description_source;
        title.favoured = _title.favoured;
        title.anons = _title.anons;
        title.ongoing = _title.ongoing;
        title.threadId = _title.thread_id;
        title.topicId = _title.topic_id;
        title.myanimelistId = _title.myanimelist_id;
        title.ratesScoresStats = _title.rates_scores_stats;
        title.ratesStatusesStats = _title.rates_statuses_stats;
        title.genres = Genre.convertFromJsonModel(_title.genres);
        title.userRate = UserRateShort.convertFromJsonModel(_title.user_rate);

        title.episodes = _title.episodes;
        title.episodesAired = _title.episodes_aired;
        title.rating = _title.rating;
        title.duration = _title.duration;
        title.updatedDateTime = DateUtils.formatDateTimeFromString(_title.updated_at);
        title.nextEpisodeDateTime = DateUtils.formatDateTimeFromString(_title.next_episode_at);
        title.studios = Studio.convertFromJsonModel(_title.studios);
        title.videos = Video.convertFromJsonModel(_title.videos);
        title.screenshots = TitleScreenshot.convertFromJsonModel(_title.screenshots);

        return title;
    }

    public static Anime[] convertFromJsonModel(_AnimeFullInfo[] _title){
        if (_title == null || _title.length == 0) { return null; }

        Anime[] title = new Anime[_title.length];
        for (int i = 0; i < _title.length; i++){
            title[i] = Anime.convertFromJsonModel(_title[i]);
        }

        return title;
    }
}
