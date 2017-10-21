package ru.shikimori.api.models.filter;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ru.shikimori.api.constants.ShikiConst;
import ru.shikimori.api.constants.enums.Order;
import ru.shikimori.api.constants.enums.TitleProgressStatus;
import ru.shikimori.api.constants.enums.TitleReleaseStatus;
import ru.shikimori.api.models.Genre;

import java.util.*;

public abstract class TitleFilter {

    protected String searchText;
    protected int limitOnPage = ShikiConst.LIMIT_ON_PAGE; // Max: 50; 1 - 100.000
    protected int page = 1;  // 1 - 100.000
    protected Order order;
    protected Map<TitleReleaseStatus, Boolean> releaseStatus = new HashMap<>();
    protected String season;
    protected int score = 0;
    protected List<Genre> genres = new ArrayList<>();
    protected boolean censored = true;
    protected Map<TitleProgressStatus, Boolean> mylist = new HashMap<>();
    protected List<Integer> ids = new ArrayList<>();
    protected List<Integer> excludeIds = new ArrayList<>();


    protected static String MapToStr(Map<? extends Filterable, Boolean> map){
        if (map == null || map.size() == 0) { return null; }

        StringBuilder str = new StringBuilder();
        for (Map.Entry<? extends Filterable, Boolean> entry : map.entrySet()){
            str.append((entry.getValue()) ? "" : "!");
            str.append(entry.getKey().getFilterData()).append(",");
        }
        return StringUtils.isNotBlank(str.toString()) ? str.substring(0, str.length() - 1) : null;
    }

    protected static String StrMapToStr(Map<String, Boolean> map){
        if (map == null || map.size() == 0) { return null; }

        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, Boolean> entry : map.entrySet()){
            str.append((entry.getValue()) ? "" : "!");
            str.append(entry.getKey()).append(",");
        }
        return StringUtils.isNotBlank(str.toString()) ? str.substring(0, str.length() - 1) : null;
    }

    protected static String ArrayToStr(List<? extends Filterable> array){
        if (array == null || array.size() == 0) { return null; }

        StringBuilder str = new StringBuilder();
        for (Filterable item : array){
            str.append(item.getFilterData()).append(",");
        }
        return StringUtils.isNotBlank(str.toString()) ? str.substring(0, str.length() - 1) : null;
    }

    protected static String IntArrayToStr(List<Integer> array){
        if (array == null || array.size() == 0) { return null; }

        StringBuilder str = new StringBuilder();
        for (int item : array){
            str.append(item).append(",");
        }
        return StringUtils.isNotBlank(str.toString()) ? str.substring(0, str.length() - 1) : null;
    }


    public TitleFilter(){}

    public TitleFilter(String searchText){
        this.searchText = searchText;
    }


    public TitleFilter limitOnPage(int limit){
        if (limit > 0 && limit <= ShikiConst.LIMIT_ON_PAGE){
            this.limitOnPage = limit;
        }
        return this;
    }

    public TitleFilter page(int page){
        if (page > 0 && page <= ShikiConst.LIMIT_MAX){
            this.page = page;
        }
        return this;
    }

    public TitleFilter orderBy(Order order){
        this.order = order;
        return this;
    }

    public TitleFilter releaseStatus(TitleReleaseStatus releaseStatus, boolean include){
        this.releaseStatus.put(releaseStatus, include);
        return this;
    }

    public TitleFilter season(String season){
        this.season = season;
        return this;
    }

    public TitleFilter scoreFrom(int score){
        this.score = score;
        return this;
    }

    public TitleFilter genres(Genre... genres){
        this.genres.addAll(Arrays.asList(genres));
        return this;
    }

    public TitleFilter isCensored(boolean censored){
        this.censored = censored;
        return this;
    }

    public TitleFilter inMyList(TitleProgressStatus status, boolean include){
        this.mylist.put(status, include);
        return this;
    }

    public TitleFilter whereIds(int... ids){
        this.ids.addAll(Arrays.asList(ArrayUtils.toObject(ids)));
        return this;
    }

    public TitleFilter withoutIds(int... excludeIds){
        this.excludeIds.addAll(Arrays.asList(ArrayUtils.toObject(excludeIds)));
        return this;
    }

    //public abstract List<? extends TitleShort> getResult();

    //public abstract List<? extends TitleShort> getResult(Credential credential);

    protected String getPartialUrl(){

        String url = "";

        if (StringUtils.isNotBlank(searchText)) {
            url += "&search=" + searchText;
        }

        if (limitOnPage > 1){
            url += "&limit=" + limitOnPage;
        }

        if (page > 1){
            url += "&page=" + page;
        }

        if (order != null){
            url += "&order=" + order.getFilterData();
        }

        if (releaseStatus.size() > 0){
            url += "&status=" + MapToStr(releaseStatus);
        }

        if (StringUtils.isNotBlank(season)){
            url += "&season=" + season;
        }

        if (score > 0){
            url += "&score=" + score;
        }

        if (genres.size() > 0){
            url += "&genre=" + ArrayToStr(genres);
        }

        if (!censored){
            url += "&censored=" + censored;
        }

        if (mylist.size() > 0){
            url += "&mylist=" + MapToStr(mylist);
        }

        if (ids.size() > 0){
            url += "&ids=" + IntArrayToStr(ids);
        }

        if (excludeIds.size() > 0){
            url += "&exclude_ids=" + IntArrayToStr(excludeIds);
        }

        return url;

    }
}
