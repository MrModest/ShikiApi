package ru.shikimori.api.models.json;

import ru.shikimori.api.models.title.TitleShort;

public class _HistoryItem {

    public int id;
    public String createdAt;
    public String description;
    public TitleShort target; // (!)

}
