package ru.shikimori.api.constants.enums;

import ru.shikimori.api.models.filter.Filterable;

public enum AnimeDuration implements Filterable {
    S, // < 10 min.
    D, // < 30 min.
    F  // > 30 min.
    ;

    @Override
    public String getFilterData() {
        return this.name();
    }
}
