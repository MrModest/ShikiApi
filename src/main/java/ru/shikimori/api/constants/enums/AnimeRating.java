package ru.shikimori.api.constants.enums;

import ru.shikimori.api.models.filter.Filterable;

public enum AnimeRating implements Filterable {
    none,   // No rating
    g,      // G - All ages
    pg,     // PG - Children
    pg_13,  // PG-13 - Teens 13 or older
    r,      // R - 17+ recommended (violence & profanity)
    r_plus, // R+ - Mild Nudity (may also contain violence & profanity)
    rx      // Rx - Hentai (extreme sexual content/nudity)
    ;

    @Override
    public String getFilterData() {
        return this.name();
    }
}
