package ru.shikimori.api.models;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ru.shikimori.api.constants.enums.Order;
import ru.shikimori.api.constants.enums.TitleProgressStatus;

import java.util.Map;

public abstract class TitleFilter {

    protected int page;  // 1 - 100.000
    protected int limit = limitOnPage; // Max: 50; 1 - 100.000
    protected Order order;
    protected Map<String, Boolean> kind; // show in constants.TitleKind
    protected Map<String, Boolean> status;
    protected String season;
    protected int score;
    protected Genre[] genres;
    protected boolean censored;
    protected Map<TitleProgressStatus, Boolean> mylist;
    protected int[] ids;
    protected int[] excludeIds;
    protected String searchText;

    protected static int limitOnPage = 50;

    protected static <T> String MapToStr(Map<T, Boolean> map){
        if (map == null) { return null; }

        String str = "";
        for (Map.Entry<T, Boolean> entry : map.entrySet()){
            str += (entry.getValue()) ? "" : "!";
            str += entry.getKey() + ",";
        }
        return StringUtils.isNotBlank(str) ? str.substring(0, str.length() - 1) : null;
    }

    protected static <T> String ArrayToStr(T[] array){
        if (array == null) { return null; }

        String str = "";
        for (T item : array){
            str += item + ",";
        }
        return StringUtils.isNotBlank(str) ? str.substring(0, str.length() - 1) : null;
    }

    public static int getLimitOnPage() {
        return limitOnPage;
    }

    public static void setLimitOnPage(int limitOnPage) {
        TitleFilter.limitOnPage = limitOnPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order.name();
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getKind() {
        return MapToStr(kind);
    }

    public void setKind(Map<String, Boolean> kind) {
        this.kind = kind;
    }

    public String getStatus() {
        return MapToStr(status);
    }

    public void setStatus(Map<String, Boolean> status) {
        this.status = status;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGenres() {
        return ArrayToStr(genres);
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    public boolean isCensored() {
        return censored;
    }

    public void setCensored(boolean censored) {
        this.censored = censored;
    }

    public String getMylist() {
        return MapToStr(mylist);
    }

    public void setMylist(Map<TitleProgressStatus, Boolean> mylist) {
        this.mylist = mylist;
    }

    public String getIds() {
        Integer[] idsShell = ArrayUtils.toObject(ids);
        return ArrayToStr(idsShell);
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public String getExcludeIds() {
        Integer[] excludeIdsShell = ArrayUtils.toObject(excludeIds);
        return ArrayToStr(excludeIdsShell);
    }

    public void setExcludeIds(int[] excludeIds) {
        this.excludeIds = excludeIds;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
