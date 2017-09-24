package ru.shikimori.api.models;

import ru.shikimori.api.constants.enums.AnimeDuration;
import ru.shikimori.api.constants.enums.AnimeRating;

public class AnimeFilter extends TitleFilter {

    private AnimeDuration duration;
    private AnimeRating rating;
    private Studio[] studios;



}
