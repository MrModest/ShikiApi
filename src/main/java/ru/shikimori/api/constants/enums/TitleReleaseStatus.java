package ru.shikimori.api.constants.enums;

import ru.shikimori.api.models.filter.Filterable;

public enum TitleReleaseStatus implements Filterable {
    anons,
    ongoing,
    latest,
    released
    ;

    @Override
    public String getFilterData() {
        return this.name();
    }

}
