package ru.shikimori.api.models.filter;

import ru.shikimori.api.constants.enums.*;
import ru.shikimori.api.models.Credential;
import ru.shikimori.api.models.Genre;
import ru.shikimori.api.models.Studio;
import ru.shikimori.api.models.title.anime.AnimeShort;
import ru.shikimori.api.requests.QueryShell;

import java.util.*;
import java.util.List;

public class AnimeFilter extends TitleFilter {

    private Map<AnimeKind, Boolean> kind = new HashMap<>();
    private Map<AnimeDuration, Boolean> duration = new HashMap<>();
    private Map<AnimeRating, Boolean> rating = new HashMap<>();
    private List<Studio> studios = new ArrayList<>();

    public AnimeFilter(){}

    public AnimeFilter(String searchText){
        super(searchText);
    }

    @Override
    public AnimeFilter limitOnPage(int limit){
        return (AnimeFilter) super.limitOnPage(limit);
    }

    @Override
    public AnimeFilter page(int page){
        return (AnimeFilter) super.page(page);
    }

    @Override
    public AnimeFilter orderBy(Order order){
        return (AnimeFilter) super.orderBy(order);
    }

    @Override
    public AnimeFilter releaseStatus(TitleReleaseStatus releaseStatus, boolean include){
        return (AnimeFilter) super.releaseStatus(releaseStatus, include);
    }

    @Override
    public AnimeFilter season(String season){
        return (AnimeFilter) super.season(season);
    }

    @Override
    public AnimeFilter scoreFrom(int score){
        return (AnimeFilter) super.scoreFrom(score);
    }

    @Override
    public AnimeFilter genres(Genre... genres){
        return (AnimeFilter) super.genres(genres);
    }

    @Override
    public AnimeFilter isCensored(boolean censored){
        return (AnimeFilter) super.isCensored(censored);
    }

    @Override
    public AnimeFilter inMyList(TitleProgressStatus status, boolean include){
        return (AnimeFilter) super.inMyList(status, include);
    }

    @Override
    public AnimeFilter whereIds(int... ids){
        return (AnimeFilter) super.whereIds(ids);
    }

    @Override
    public AnimeFilter withoutIds(int... excludeIds){
        return (AnimeFilter) super.withoutIds(excludeIds);
    }


    public AnimeFilter kind(AnimeKind kind, boolean include){
        this.kind.put(kind, include);
        return this;
    }

    public AnimeFilter duration(AnimeDuration duration, boolean include){
        this.duration.put(duration, include);
        return this;
    }

    public AnimeFilter rating(AnimeRating rating, boolean include){
        this.rating.put(rating, include);
        return this;
    }

    public AnimeFilter studios(Studio... studios){
        this.studios.addAll(Arrays.asList(studios));
        return this;
    }


    public AnimeShort[] getResult(){
        return getResult(null);
    }

    public AnimeShort[] getResult(Credential credential){

        String url = "animes?" + getPartialUrl();

        if (kind.size() > 0){
            url += "&type=" + MapToStr(kind);
        }

        if (duration.size() > 0){
            url += "&duration=" + MapToStr(duration);
        }

        if (rating.size() > 0){
            url += "&rating=" + MapToStr(rating);
        }

        if (studios.size() > 0){
            url += "&studio=" + ArrayToStr(studios);
        }

        if (credential != null){
            return QueryShell.get(url, AnimeShort[].class, credential);
        }
        else {
            return QueryShell.get(url, AnimeShort[].class);
        }
    }
}
