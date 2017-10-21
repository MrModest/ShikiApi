package ru.shikimori.api.constants.enums;

import ru.shikimori.api.models.filter.Filterable;

public enum  TitleProgressStatus implements Filterable {
    planned,
    watching,
    completed,
    on_hold,
    dropped
    ;

    @Override
    public String getFilterData() {
        return this.name();
    }
}
