package ru.shikimori.api.models;

import ru.shikimori.api.constants.enums.AnimeDuration;
import ru.shikimori.api.constants.enums.AnimeRating;

public class AnimeFilter extends TitleFilter {

    private AnimeDuration duration;
    private AnimeRating rating;
    private Studio[] studios;


    public String getDuration() {
        return duration.name();
    }

    public void setDuration(AnimeDuration duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating.name();
    }

    public void setRating(AnimeRating rating) {
        this.rating = rating;
    }

    public String getStudios() {
        return ArrayToStr(studios);
    }

    public void setStudios(Studio[] studios) {
        this.studios = studios;
    }
}
