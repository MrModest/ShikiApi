package ru.shikimori.api.constants.enums;

import ru.shikimori.api.models.filter.Filterable;

public enum Order implements Filterable {
    id,
    ranked,
    type, // kind
    popularity,
    name,
    aired_on,
    episodes,
    volumes,
    chapters,
    status,
    random
    ;

    @Override
    public String getFilterData() {
        return this.name();
    }
}
