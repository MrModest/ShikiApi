package ru.shikimori.api.models.filter;

import ru.shikimori.api.constants.enums.MangaKind;
import ru.shikimori.api.constants.enums.Order;
import ru.shikimori.api.constants.enums.TitleProgressStatus;
import ru.shikimori.api.constants.enums.TitleReleaseStatus;
import ru.shikimori.api.models.Credential;
import ru.shikimori.api.models.Genre;
import ru.shikimori.api.models.Publisher;
import ru.shikimori.api.models.title.manga.Manga;
import ru.shikimori.api.models.title.manga.MangaShort;
import ru.shikimori.api.requests.QueryShell;

import java.util.*;

public class MangaFilter extends TitleFilter {

    private Map<MangaKind, Boolean> kind = new HashMap<>();
    private List<Publisher> publishers = new ArrayList<>();

    public MangaFilter(){}

    public MangaFilter(String searchText){
        super(searchText);
    }

    @Override
    public MangaFilter limitOnPage(int limit){
        return (MangaFilter) super.limitOnPage(limit);
    }

    @Override
    public MangaFilter page(int page){
        return (MangaFilter) super.page(page);
    }

    @Override
    public MangaFilter orderBy(Order order){
        return (MangaFilter) super.orderBy(order);
    }

    @Override
    public MangaFilter releaseStatus(TitleReleaseStatus releaseStatus, boolean include){
        return (MangaFilter) super.releaseStatus(releaseStatus, include);
    }

    @Override
    public MangaFilter season(String season){
        return (MangaFilter) super.season(season);
    }

    @Override
    public MangaFilter scoreFrom(int score){
        return (MangaFilter) super.scoreFrom(score);
    }

    @Override
    public MangaFilter genres(Genre... genres){
        return (MangaFilter) super.genres(genres);
    }

    @Override
    public MangaFilter isCensored(boolean censored){
        return (MangaFilter) super.isCensored(censored);
    }

    @Override
    public MangaFilter inMyList(TitleProgressStatus status, boolean include){
        return (MangaFilter) super.inMyList(status, include);
    }

    @Override
    public MangaFilter whereIds(int... ids){
        return (MangaFilter) super.whereIds(ids);
    }

    @Override
    public MangaFilter withoutIds(int... excludeIds){
        return (MangaFilter) super.withoutIds(excludeIds);
    }


    public MangaFilter kind(MangaKind kind, boolean include){
        this.kind.put(kind, include);
        return this;
    }

    public MangaFilter publishers(Publisher... publisher){
        this.publishers.addAll(Arrays.asList(publisher));
        return this;
    }


    public MangaShort[] getResult(){
        return getResult(null);
    }

    public MangaShort[] getResult(Credential credential){

        String url = "mangas?" + getPartialUrl();

        if (kind.size() > 0){
            url += "&type=" + MapToStr(kind);
        }

        if (publishers.size() > 0){
            url += "&publisher=" + ArrayToStr(publishers);
        }

        if (credential != null){
            return QueryShell.get(url, MangaShort[].class, credential);
        }
        else {
            return QueryShell.get(url, MangaShort[].class);
        }
    }
}
