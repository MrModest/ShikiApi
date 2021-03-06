package ru.shikimori.api.constants.enums;

import ru.shikimori.api.models.filter.Filterable;

public enum TitleType implements Filterable {
    Anime,
    Manga
    ;

    @Override
    public String getFilterData() {
        return this.name();
    }
}
