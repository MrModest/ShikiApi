package ru.shikimori.api.models;

import ru.shikimori.api.models.json._MangaFullInfo;
import ru.shikimori.api.requests.QueryShell;
import ru.shikimori.api.utils.DateUtils;

public class Manga extends Title {

    private int volumes;
    private int chapters;
    private Publisher[] publishers;

    private Manga(){}

    public int getVolumes() {
        return volumes;
    }

    public int getChapters() {
        return chapters;
    }

    public Publisher[] getPublishers() {
        return publishers;
    }

    public static Manga getById(int titleId){
        if (titleId < 1) { return null; }

        return Manga.convertFromJsonModel(QueryShell.get("mangas/" + titleId, _MangaFullInfo.class));
    }

    public static Manga getById(int titleId, Credential credential){
        if (titleId < 1) { return null; }

        return Manga.convertFromJsonModel(QueryShell.get("mangas/" + titleId, _MangaFullInfo.class, credential));
    }

    public static Manga convertFromJsonModel(_MangaFullInfo _title){
        if (_title == null) { return null; }

        Manga title = new Manga();
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

        title.volumes = _title.volumes;
        title.chapters = _title.chapters;
        title.publishers = Publisher.convertFromJsonModel(_title.publishers);

        return title;
    }

    public static Manga[] convertFromJsonModel(_MangaFullInfo[] _title){
        if (_title == null || _title.length == 0) { return null; }

        Manga[] title = new Manga[_title.length];
        for (int i = 0; i < _title.length; i++){
            title[i] = Manga.convertFromJsonModel(_title[i]);
        }

        return title;
    }
}
